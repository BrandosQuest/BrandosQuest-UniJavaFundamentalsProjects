package ElevatorPackage;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class ElevatorSimulator implements Serializable {
    private final Elevator elevator;
    private final Building building;
    private final LinkedList<Call> calls;
    private Queue<String> actions;

    public ElevatorSimulator(Building building, int position, int maxPeopleLoad) {
        this.building = building;
        elevator = new Elevator(building, position, maxPeopleLoad);
        calls = new LinkedList<>();
        actions = new LinkedList<>();
    }
    public void elevatorCall(int originFloor, int destinationFloor, boolean onElevator) {
        calls.add(new Call( originFloor, destinationFloor, building, onElevator));//if on elevator add to people on elevator
    }
    public void simulate() {
        //int counter=0;
        while (!calls.isEmpty()) {
            int directionScore=0;
            int callsMade=0;
            int callsCompleted=0;
            int callsSkipped=0;
            ListIterator<Call> iterator = calls.listIterator();
            while (iterator.hasNext()) {
                Call call = iterator.next();
                if(call.getOriginFloor()==elevator.position()){
                    //call.setOnElevator(true);
                    try {
                        elevator.setPeopleLoad(1);//but they should be already on elevator
                        call.setOnElevator(true);
                        callsMade++;
                    } catch (IllegalArgumentException e) {
                        callsSkipped++;
                    }
                    //callsMade++;
                }
                if(call.isOnElevator()){
                    if(call.getDestinationFloor()>elevator.position()){
                        directionScore++;
                    }else if(call.getDestinationFloor()==elevator.position()) {
                        elevator.setPeopleLoad(-1);
                        callsCompleted++;
                        iterator.remove();
                        continue;
                    }else {
                        directionScore--;
                    }
                }else {
                    if(call.getOriginFloor()>elevator.position()){
                        directionScore++;
                    }else if(call.getOriginFloor()<elevator.position()) {
                        directionScore--;
                    } /*else {
                        directionScore--;
                    }*/
                }
            }
            /*counter++;
            if(counter==16) {
                System.out.println("a");
            }*/
            //System.out.println(elevator.position());
            String buffer = "\n" + "Elevator at floor " + elevator.position() +
                    " Calls made: " + callsMade +
                    " Calls completed: " + callsCompleted +
                    " People on elevator:" + elevator.getPeopleLoad() +
                    " directionScore: " + directionScore;//temporary
            if(callsSkipped>0){
                buffer = buffer + " Skipped calls due to exceeding the weight limit: " + callsSkipped;
            }
            System.out.println(buffer);
            actions.add(buffer);
            /*actions.add("\n"+"Elevator at floor "+elevator.position());
            actions.add("Calls made: "+callsMade);
            actions.add("Calls completed: "+callsCompleted);
            actions.add("People on elevator:"+elevator.getPeopleLoad());
            actions.add("directionScore: "+directionScore);*/
            if(directionScore>0) {
                elevator.moveOneFloor(Direction.UP);
            }if(directionScore==0) {//check if it's right
                elevator.moveOneFloor(Direction.UP);
            }if(directionScore<0){
                elevator.moveOneFloor(Direction.DOWN);
            }
        }

        /*il piano toccato dall'ascensore,
● quante persone scendono e salgono
● quante persone sono presenti sull'ascensore*/
    }
    public String printActions() {

        return actions.toString();
    }
    public Building getBuilding() {
        return building;
    }

    public int getElevatorPosition() {
        return elevator.position();
    }

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
