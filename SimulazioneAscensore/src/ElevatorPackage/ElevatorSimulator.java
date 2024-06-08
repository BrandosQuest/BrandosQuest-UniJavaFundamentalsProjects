package ElevatorPackage;

import java.util.LinkedList;
import java.util.Queue;

public class ElevatorSimulator {
    Elevator elevator;
    Building building;
    LinkedList<Call> calls;
    Queue<String> actions;

    public ElevatorSimulator(Building building, int maxPeopleLoad, int position) {
        building = building;
        elevator = new Elevator(maxPeopleLoad, position, building);

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
