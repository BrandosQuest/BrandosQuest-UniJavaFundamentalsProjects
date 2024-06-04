package ElevatorPackage;

import java.util.LinkedList;
import java.util.Queue;

public class ElevatorSimulator {
    Queue<String> actions;
    Elevator elevator;
    LinkedList<Call> calls;

    public ElevatorSimulator(Building building, int maxPeopleLoad, int position) {
        elevator = new Elevator(maxPeopleLoad, position, building);
    }
    public void elevatorCall(Call call) {
        calls.add(call);
    }
    public void simulate() {
        actions = new LinkedList<>();
    }
    public String printActions() {
        return actions.toString();
    }
}
