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
    private Direction previousDirection = null;

    public ElevatorSimulator(Building building, int position, int maxPeopleLoad) {
        this.building = building;
        elevator = new Elevator(building, position, maxPeopleLoad);
        calls = new LinkedList<>();
        actions = new LinkedList<>();
    }
    public void elevatorCall(int originFloor, int destinationFloor) throws IllegalArgumentException {
        /*if (onElevator) {
            elevator.setPeopleLoad(1);
        }*/
        calls.add(new Call( originFloor, destinationFloor, building));//if on elevator add to people on elevator
    }
    public void simulate() {
        //int counter=0;
        //Direction previousDirection = null;// Direction.UP//if it starts at the top???
        while (!calls.isEmpty()) {//this cycles until there's no call left
            int directionScore=0;
            int callsMade=0;
            int callsCompleted=0;
            int callsSkipped=0;
            ListIterator<Call> iterator = calls.listIterator();
            while (iterator.hasNext()) {
                Call call = iterator.next();
                /*if (elevator.position()==call.getOriginFloor() || elevator.getPeopleLoad()==0){
                    call.setSkipped(false);
                }*/
                if(call.getOriginFloor()==elevator.position() && !call.isOnElevator()){//this tries to take calls on the elevator that are not on the elevator
                    //call.setOnElevator(true);
                    try {
                        elevator.setPeopleLoad(1);//but they should be already on elevator
                        call.setOnElevator(true);
                        //System.out.println(call);
                        callsMade++;
                    } catch (IllegalArgumentException e) {
                        callsSkipped++;
                        call.setSkipped(true);
                    }
                    //callsMade++;
                }
                //if(call.isOnElevator() && !call.wasSkipped()){
                if(call.isOnElevator()){//if the call is on elevator
                    if(call.getDestinationFloor()>elevator.position()){
                        directionScore++;
                    //}else if(call.getDestinationFloor()==elevator.position() && call.isOnElevator()) {
                    }else if(call.getDestinationFloor()==elevator.position()) {
                        elevator.setPeopleLoad(-1);
                        callsCompleted++;
                        iterator.remove();
                        continue;
                    }else if (call.getDestinationFloor()<elevator.position()){
                        directionScore--;
                    }
                //}else if (!call.wasSkipped() && elevator.getPeopleLoad()<elevator.getMaxPeopleLoad()){
                }
                if (elevator.position()==call.getOriginFloor() || elevator.getPeopleLoad()==0){
                    call.setSkipped(false);
                }
                if (!call.isOnElevator() && !call.wasSkipped() && elevator.getPeopleLoad()<elevator.getMaxPeopleLoad()){//if the call is not on the elevator and wasn't skipped and the elevator is not full
                    if(call.getOriginFloor()>elevator.position()){
                        directionScore++;
                    }else if(call.getOriginFloor()<elevator.position()) {
                        directionScore--;
                    } /*else {
                        directionScore--;
                    }*/
                }
            }/*while (iterator.hasNext()) {
                Call call = iterator.next();
                if (elevator.position()==call.getOriginFloor() || elevator.getPeopleLoad()==0){
                    call.setSkipped(false);
                }
                if(call.getOriginFloor()==elevator.position() && !call.isOnElevator()){//this tries to take calls on the elevator that are not on the elevator
                    //call.setOnElevator(true);
                    try {
                        elevator.setPeopleLoad(1);//but they should be already on elevator
                        call.setOnElevator(true);
                        //System.out.println(call);
                        callsMade++;
                    } catch (IllegalArgumentException e) {
                        callsSkipped++;
                        call.setSkipped(true);
                    }
                    //callsMade++;
                }
                //if(call.isOnElevator() && !call.wasSkipped()){
                if(call.isOnElevator()){//if the call is on elevator
                    if(call.getDestinationFloor()>elevator.position()){
                        directionScore++;
                        //}else if(call.getDestinationFloor()==elevator.position() && call.isOnElevator()) {
                    }else if(call.getDestinationFloor()==elevator.position()) {
                        elevator.setPeopleLoad(-1);
                        callsCompleted++;
                        iterator.remove();
                        continue;
                    }else if (call.getDestinationFloor()<elevator.position()){
                        directionScore--;
                    }
                    //}else if (!call.wasSkipped() && elevator.getPeopleLoad()<elevator.getMaxPeopleLoad()){
                }else if (!call.wasSkipped() && elevator.getPeopleLoad()<elevator.getMaxPeopleLoad()){//if the call is not on the elevator and wasn't skipped and the elevator is not full
                    if(call.getOriginFloor()>elevator.position()){
                        directionScore++;
                    }else if(call.getOriginFloor()<elevator.position()) {
                        directionScore--;
                    } *//*else {
                        directionScore--;
                    }*//*
                }
            }*/
            //counter++;
            //System.out.println(elevator.position());
            StringBuilder buffer= new StringBuilder();
            buffer.append("\n" + "Elevator at floor " + elevator.position() +
                    ", Calls made: " + callsMade +
                    ", Calls completed: " + callsCompleted +
                    ", People on elevator:" + elevator.getPeopleLoad());
                    //", directionScore: " + directionScore);//temporary
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
            //System.out.print(buffer);
            actions.add(buffer.toString());
            /*actions.add("\n"+"Elevator at floor "+elevator.position());
            actions.add("Calls made: "+callsMade);
            actions.add("Calls completed: "+callsCompleted);
            actions.add("People on elevator:"+elevator.getPeopleLoad());
            actions.add("directionScore: "+directionScore);*/
            /*if(directionScore>0) {
                elevator.moveOneFloor(Direction.UP);
            }else if(directionScore<0){
                elevator.moveOneFloor(Direction.DOWN);
            }else if(directionScore==0){
                elevator.moveOneFloor(Direction.UP);//or move the last move?
            }else if(elevator.position()==building.getHighestFloor()) {//check if it's right
                elevator.moveOneFloor(Direction.DOWN);
            }else if(elevator.position()==building.getLowestFloor()) {//check if it's right
                elevator.moveOneFloor(Direction.UP);
            }*/


            if(elevator.position()==building.getHighestFloor()) {//check if it's right
                elevator.moveOneFloor(Direction.DOWN);
                previousDirection=Direction.DOWN;
            }else if(elevator.position()==building.getLowestFloor()) {//check if it's right
                elevator.moveOneFloor(Direction.UP);
                previousDirection=Direction.UP;
            }else if(directionScore>0) {
                elevator.moveOneFloor(Direction.UP);
                previousDirection=Direction.UP;
            }else if(directionScore<0){
                elevator.moveOneFloor(Direction.DOWN);
                previousDirection=Direction.DOWN;
            }else {
                elevator.moveOneFloor(previousDirection);//or move the last move?
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
    public String simulateAStep(String command) {
        //Direction previousDirection = null;// Direction.UP//if it starts at the top???
        if (!calls.isEmpty()) {//this cycles until there's no call left
            int directionScore=0;
            int callsMade=0;
            int callsCompleted=0;
            int callsSkipped=0;
            if(command.equalsIgnoreCase("help")){
                elevator.setPeopleLoad(-elevator.getPeopleLoad());
                ListIterator<Call> iterator = calls.listIterator();
                while (iterator.hasNext()) {
                    Call call = iterator.next();
                    if(call.isOnElevator()){
                        call.setOriginFloor(elevator.position());
                    }
                    call.setOnElevator(false);
                }
            }else {

                ListIterator<Call> iterator = calls.listIterator();
                while (iterator.hasNext()) {
                    Call call = iterator.next();
                /*if (elevator.position()==call.getOriginFloor() || elevator.getPeopleLoad()==0){
                    call.setSkipped(false);
                }*/
                    if(call.getOriginFloor()==elevator.position() && !call.isOnElevator()){//this tries to take calls on the elevator that are not on the elevator
                        //call.setOnElevator(true);
                        try {
                            elevator.setPeopleLoad(1);//but they should be already on elevator
                            call.setOnElevator(true);
                            //System.out.println(call);
                            callsMade++;
                        } catch (IllegalArgumentException e) {
                            callsSkipped++;
                            call.setSkipped(true);
                        }
                        //callsMade++;
                    }
                    //if(call.isOnElevator() && !call.wasSkipped()){
                    if(call.isOnElevator()){//if the call is on elevator
                        if(call.getDestinationFloor()>elevator.position()){
                            directionScore++;
                            //}else if(call.getDestinationFloor()==elevator.position() && call.isOnElevator()) {
                        }else if(call.getDestinationFloor()==elevator.position()) {
                            elevator.setPeopleLoad(-1);
                            callsCompleted++;
                            iterator.remove();
                            continue;
                        }else if (call.getDestinationFloor()<elevator.position()){
                            directionScore--;
                        }
                        //}else if (!call.wasSkipped() && elevator.getPeopleLoad()<elevator.getMaxPeopleLoad()){
                    }
                    if (elevator.position()==call.getOriginFloor() || elevator.getPeopleLoad()==0){
                        call.setSkipped(false);
                    }
                    if (!call.isOnElevator() && !call.wasSkipped() && elevator.getPeopleLoad()<elevator.getMaxPeopleLoad()){//if the call is not on the elevator and wasn't skipped and the elevator is not full
                        if(call.getOriginFloor()>elevator.position()){
                            directionScore++;
                        }else if(call.getOriginFloor()<elevator.position()) {
                            directionScore--;
                        } /*else {
                        directionScore--;
                    }*/
                    }
                }
            }

            /*while (iterator.hasNext()) {
                Call call = iterator.next();
                if (elevator.position()==call.getOriginFloor() || elevator.getPeopleLoad()==0){
                    call.setSkipped(false);
                }
                if(call.getOriginFloor()==elevator.position() && !call.isOnElevator()){//this tries to take calls on the elevator that are not on the elevator
                    //call.setOnElevator(true);
                    try {
                        elevator.setPeopleLoad(1);//but they should be already on elevator
                        call.setOnElevator(true);
                        //System.out.println(call);
                        callsMade++;
                    } catch (IllegalArgumentException e) {
                        callsSkipped++;
                        call.setSkipped(true);
                    }
                    //callsMade++;
                }
                //if(call.isOnElevator() && !call.wasSkipped()){
                if(call.isOnElevator()){//if the call is on elevator
                    if(call.getDestinationFloor()>elevator.position()){
                        directionScore++;
                        //}else if(call.getDestinationFloor()==elevator.position() && call.isOnElevator()) {
                    }else if(call.getDestinationFloor()==elevator.position()) {
                        elevator.setPeopleLoad(-1);
                        callsCompleted++;
                        iterator.remove();
                        continue;
                    }else if (call.getDestinationFloor()<elevator.position()){
                        directionScore--;
                    }
                    //}else if (!call.wasSkipped() && elevator.getPeopleLoad()<elevator.getMaxPeopleLoad()){
                }else if (!call.wasSkipped() && elevator.getPeopleLoad()<elevator.getMaxPeopleLoad()){//if the call is not on the elevator and wasn't skipped and the elevator is not full
                    if(call.getOriginFloor()>elevator.position()){
                        directionScore++;
                    }else if(call.getOriginFloor()<elevator.position()) {
                        directionScore--;
                    } *//*else {
                        directionScore--;
                    }*//*
                }
            }*/
            //counter++;
            //System.out.println(elevator.position());
            StringBuilder buffer= new StringBuilder();
            buffer.append("\n" + "Elevator at floor " + elevator.position() +
                    ", Calls made: " + callsMade +
                    ", Calls completed: " + callsCompleted +
                    ", People on elevator:" + elevator.getPeopleLoad());
                    //", directionScore: " + directionScore);//temporary
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
            //System.out.print(buffer);

            /*actions.add("\n"+"Elevator at floor "+elevator.position());
            actions.add("Calls made: "+callsMade);
            actions.add("Calls completed: "+callsCompleted);
            actions.add("People on elevator:"+elevator.getPeopleLoad());
            actions.add("directionScore: "+directionScore);*/
            /*if(directionScore>0) {
                elevator.moveOneFloor(Direction.UP);
            }else if(directionScore<0){
                elevator.moveOneFloor(Direction.DOWN);
            }else if(directionScore==0){
                elevator.moveOneFloor(Direction.UP);//or move the last move?
            }else if(elevator.position()==building.getHighestFloor()) {//check if it's right
                elevator.moveOneFloor(Direction.DOWN);
            }else if(elevator.position()==building.getLowestFloor()) {//check if it's right
                elevator.moveOneFloor(Direction.UP);
            }*/


            if(elevator.position()==building.getHighestFloor()) {//check if it's right
                elevator.moveOneFloor(Direction.DOWN);
                previousDirection=Direction.DOWN;
            }else if(elevator.position()==building.getLowestFloor()) {//check if it's right
                elevator.moveOneFloor(Direction.UP);
                previousDirection=Direction.UP;
            }else if(directionScore>0) {
                elevator.moveOneFloor(Direction.UP);
                previousDirection=Direction.UP;
            }else if(directionScore<0){
                elevator.moveOneFloor(Direction.DOWN);
                previousDirection=Direction.DOWN;
            }else {
                elevator.moveOneFloor(previousDirection);//or move the last move?
            }
            return buffer.toString();
        }
        else {
            return "";
        }
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
