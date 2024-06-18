package ElevatorPackage;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

/**
 * The class that represents the simulator, and houses all the logic for the decisions in the elevator movement
 * Implements the Serializable interface to enable this class to bne saved
 * @author brando
 */
public class ElevatorSimulator implements Serializable {
    /**
     * The elevator object used in the class
     */
    private final Elevator elevator;
    /**
     *The building object used in the class
     */
    private final Building building;
    /**
     *Represents the list of calls that the elevator must answer
     */
    private final LinkedList<Call> calls;
    /**
     *Represents the list of steps that the elevator must execute to complete the calls
     */
    private final Queue<String> actions;
    /**
     *A direction object used to store the value of the previous movement in case of the use of the simulateAStep method
     */
    private Direction previousDirection = null;

    /**Constructor of the ElevatorSimulator class, returns an object of the class and initializes the attributes of the class
     * @param building The building object used in the class, used to access the min and max floor number and to create the elevator object
     * @param position The initial position of the elevator
     * @param maxPeopleLoad The maximum people load of the elevator object
     */
    public ElevatorSimulator(Building building, int position, int maxPeopleLoad) {
        this.building = building;
        elevator = new Elevator(building, position, maxPeopleLoad);
        calls = new LinkedList<>();
        actions = new LinkedList<>();
    }

    /** This method adds a new call to the calls list
     * @param originFloor  The number of the floor where the call was made
     * @param destinationFloor The number of the floor where the call will be taken to completion
     * @throws IllegalArgumentException If one of the new call parameters is higher or lower than what's acceptable in the building the call constructor throws an exception echoed back to the caller of this method
     */
    public void elevatorCall(int originFloor, int destinationFloor) throws IllegalArgumentException {
        calls.add(new Call( originFloor, destinationFloor, building));
    }

    /**Getter of the Building attribute, used by the inputs methods for checking the use inputs correctness
     * @return The building object
     */
    public Building getBuilding() {
        return building;
    }
    /**
     * This is the default method that houses the logic for the movement and tasks of the elevator, it stores all the steps in the action list, later printed on the screen
     */
    public void simulate() {
        while (!calls.isEmpty()) {//this cycles until there's no call left
            int directionScore=0;
            int callsMade=0;
            int callsCompleted=0;
            int callsSkipped=0;
            ListIterator<Call> iterator = calls.listIterator();
            while (iterator.hasNext()) {
                Call call = iterator.next();
                if(call.getOriginFloor()==elevator.position() && !call.isOnElevator()){//this tries to take calls on the elevator that are not on the elevator
                    try {
                        elevator.setPeopleLoad(1);
                        call.setOnElevator(true);
                        callsMade++;
                    } catch (IllegalArgumentException e) {
                        callsSkipped++;
                        call.setSkipped(true);
                    }
                }
                if(call.isOnElevator()){//if the call is on elevator
                    if(call.getDestinationFloor()>elevator.position()){
                        directionScore++;
                    }else if(call.getDestinationFloor()==elevator.position()) {
                        elevator.setPeopleLoad(-1);
                        callsCompleted++;
                        iterator.remove();
                        continue;
                    }else if (call.getDestinationFloor()<elevator.position()){
                        directionScore--;
                    }
                }
                if (elevator.position()==call.getOriginFloor() || elevator.getPeopleLoad()==0){
                    call.setSkipped(false);
                }
                if (!call.isOnElevator() && call.wasNotSkipped() && elevator.getPeopleLoad()<elevator.getMaxPeopleLoad()){//if the call is not on the elevator and wasn't skipped and the elevator is not full
                    if(call.getOriginFloor()>elevator.position()){
                        directionScore++;
                    }else if(call.getOriginFloor()<elevator.position()) {
                        directionScore--;
                    }
                }
            }
            String step = stepStringBuilder(callsMade, callsCompleted, callsSkipped);
            actions.add(step);
            elevatorMover(directionScore);
        }
    }

    /**Method that returns a string of the action made by the elevator during the simulation
     * @return a string of the action made by the elevator during the simulation
     */
    public String printActions() {
        return actions.toString();
    }
    /**
     * This is a variant of the simulate method that houses the logic for the movement and tasks of the elevator.
     * according to the input received it returns the step taken, if it receives "help" it executes an emergency call
     * @param command the String that is checked before executing an emergency call
     * @return the String representing the step taken by the elevator
     */
    public String simulateAStep(String command) {
        if (!calls.isEmpty()) {//this cycles until there's no call left
            int directionScore=0;
            int callsMade=0;
            int callsCompleted=0;
            int callsSkipped=0;
            if(command.equalsIgnoreCase("help")){
                elevator.setPeopleLoad(-elevator.getPeopleLoad());
                for (Call call : calls) {
                    if (call.isOnElevator()) {
                        call.setOriginFloor(elevator.position());
                    }
                    call.setOnElevator(false);
                }
            }else {
                ListIterator<Call> iterator = calls.listIterator();
                while (iterator.hasNext()) {
                    Call call = iterator.next();
                    if(call.getOriginFloor()==elevator.position() && !call.isOnElevator()){//this tries to take calls on the elevator that are not on the elevator
                        try {
                            elevator.setPeopleLoad(1);
                            call.setOnElevator(true);
                            callsMade++;
                        } catch (IllegalArgumentException e) {
                            callsSkipped++;
                            call.setSkipped(true);
                        }
                    }
                    if(call.isOnElevator()){//if the call is on elevator
                        if(call.getDestinationFloor()>elevator.position()){
                            directionScore++;
                        }else if(call.getDestinationFloor()==elevator.position()) {
                            elevator.setPeopleLoad(-1);
                            callsCompleted++;
                            iterator.remove();
                            continue;
                        }else if (call.getDestinationFloor()<elevator.position()){
                            directionScore--;
                        }
                    }
                    if (elevator.position()==call.getOriginFloor() || elevator.getPeopleLoad()==0){
                        call.setSkipped(false);
                    }
                    if (!call.isOnElevator() && call.wasNotSkipped() && elevator.getPeopleLoad()<elevator.getMaxPeopleLoad()){//if the call is not on the elevator and wasn't skipped and the elevator is not full
                        if(call.getOriginFloor()>elevator.position()){
                            directionScore++;
                        }else if(call.getOriginFloor()<elevator.position()) {
                            directionScore--;
                        }
                    }
                }
            }

            String step=stepStringBuilder(callsMade, callsCompleted, callsSkipped);
            elevatorMover(directionScore);
            return step;
        } else {
            return "";
        }
    }

    /**This method builds a string from the parameters received, representing the step taken by the elevator
     * @param callsMade the calls that the elevator has boarded at this floor
     * @param callsCompleted the calls that the elevator has completed at this floor
     * @param callsSkipped the calls that the elevator has skipped at this floor
     * @return string representing the step taken by the elevator
     */
    private String stepStringBuilder(int callsMade, int callsCompleted, int callsSkipped) {
        StringBuilder buffer= new StringBuilder();
        buffer.append("\n" + "Elevator at floor " + elevator.position() +
                ", Calls made: " + callsMade +
                ", Calls completed: " + callsCompleted +
                ", People on elevator:" + elevator.getPeopleLoad());
        if(callsSkipped>0){
            buffer.append(", Skipped calls(due to exceeding the weight limit): ").append(callsSkipped);
        }
        buffer.append("\n");
        for (int i = building.getLowestFloor(); i <= building.getHighestFloor(); i++) {
            if (i!=elevator.position()) {
                buffer.append(i);
            } else {
                buffer.append("█");
            }
            buffer.append("\t");
        }
        return buffer.toString();
    }

    /** this method moves the elevator according to the direction asked, or to the position it has in the building
     * @param directionScore Integer, positive for going up, negative for going down
     */
    private void elevatorMover(int directionScore) {
        if(elevator.position()==building.getHighestFloor()) {
            elevator.moveOneFloor(Direction.DOWN);
            previousDirection=Direction.DOWN;
        }else if(elevator.position()==building.getLowestFloor()) {
            elevator.moveOneFloor(Direction.UP);
            previousDirection=Direction.UP;
        }else if(directionScore>0) {
            elevator.moveOneFloor(Direction.UP);
            previousDirection=Direction.UP;
        }else if(directionScore<0){
            elevator.moveOneFloor(Direction.DOWN);
            previousDirection=Direction.DOWN;
        }else {
            elevator.moveOneFloor(previousDirection);
        }
    }

    /**ToString method of Elevator simulator
     * @return A string representing the current state of the ElevatorSimulator
     */
    @Override
    public String toString() {
        return "ElevatorSimulator{" +
                "\nelevator=" + elevator +
                ", \nbuilding=" + building +
                ", \ncalls=" + calls +
                ", \nactions=" + actions +
                '}';
    }


}
