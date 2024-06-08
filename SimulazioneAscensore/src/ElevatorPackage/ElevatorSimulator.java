package ElevatorPackage;

import java.util.LinkedList;
import java.util.Queue;

public class ElevatorSimulator {
    private final Elevator elevator;
    private final Building building;
    private final LinkedList<Call> calls;
    private Queue<String> actions;

    public ElevatorSimulator(Building building, int maxPeopleLoad, int position) {
        this.building = building;
        if(!(position>=building.getLowestFloor() && position<=building.getHighestFloor())){
            throw new IllegalArgumentException("Elevator position is out of bounds in respect to the building floors numbers");
        }else {
            elevator = new Elevator(maxPeopleLoad, position, building.getLowestFloor(), building.getHighestFloor());
        }
        calls = new LinkedList<>();
        actions = new LinkedList<>();
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
                "elevator=" + elevator +
                ", building=" + building +
                ", calls=" + calls +
                ", actions=" + actions +
                '}';
    }
}
