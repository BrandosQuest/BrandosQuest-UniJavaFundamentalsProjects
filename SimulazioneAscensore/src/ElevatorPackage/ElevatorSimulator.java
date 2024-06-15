package ElevatorPackage;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

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
    public void elevatorCall(int originFloor, int destinationFloor ) {
        calls.add(new Call( originFloor, destinationFloor, building));
    }
    public void simulate() {
        TreeMap<Integer, Float> floorPriority = new TreeMap<>();
        for (Call call : calls) {
            floorPriority.merge(call.getOriginFloor(), 1F, Float::sum);
        }
        System.out.println(floorPriority);
        for(int i = building.getLowestFloor(); i <= building.getHighestFloor(); i++) {
            System.out.println(i);
        }
        Direction direction=Direction.UP;
        while (!calls.isEmpty()) {
            for (int i = 0; i < calls.size(); i++) {//use iterator?
                if (calls.get(i).getOriginFloor() == elevator.position()) {
                    actions.add("elevator lets pearson on board");
                    direction = calls.get(i).getDirection();
                }
                if (calls.get(i).getDestinationFloor() == elevator.position()) {
                    actions.add("elevator drops down a pearson");
                    calls.remove(i);
                }
            }
            elevator.moveOneFloor(direction);
        }
    }
    public String printActions() {
        return actions.toString();
    }
    public Building getBuilding() {
        return building;
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
