package ElevatorPackage;

import java.io.Serializable;
import java.util.LinkedList;
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
    }
    public void elevatorCall(int originFloor, int destinationFloor ) {
        calls.add(new Call( originFloor, destinationFloor, building));
    }
    public void simulate() {
        actions = new LinkedList<>();

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
