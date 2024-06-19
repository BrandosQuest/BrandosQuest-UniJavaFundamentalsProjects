package Tests;

import ElevatorPackage.Building;
import ElevatorPackage.ElevatorSimulator;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

/**
 * The ElevatorSimulatorTest class, containing the junit tests
 * @author brando
 */
public class ElevatorSimulatorTest {
    /**
     * The Building object, tested in the BuildingTests class, used to initiate the objects tested
     */
    private final Building building = new Building(10, 1);

    /**
     * This method tests for the correct behaviour of the constructor, and the correct errors in case of bad parameters
     */
    @Test
    public void Constructor() {
        ElevatorSimulator simulator = new ElevatorSimulator(building, 3, 3);
        assertNotNull(simulator);
        assertThrows(IllegalArgumentException.class, () -> {
            new ElevatorSimulator(building, 101, 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new ElevatorSimulator(building, 1, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new ElevatorSimulator(building, 1, -100);
        });
    }

    /**
     * This method tests for the correct behaviour of a simulation of a call going up
     */
    @Test
    public void SimulationCallGoingUP() {
        ElevatorSimulator simulator = new ElevatorSimulator(building, 3, 2);
        simulator.elevatorCall(0, 2);
        simulator.simulate();
        assertEquals(simulator.printActions(), "[\n" +
                "Elevator at floor 3, Calls made: 0, Calls completed: 0, People on elevator:0\n" +
                "-1\t0\t1\t2\t█\t4\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 2, Calls made: 0, Calls completed: 0, People on elevator:0\n" +
                "-1\t0\t1\t█\t3\t4\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 1, Calls made: 0, Calls completed: 0, People on elevator:0\n" +
                "-1\t0\t█\t2\t3\t4\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 0, Calls made: 1, Calls completed: 0, People on elevator:1\n" +
                "-1\t█\t1\t2\t3\t4\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 1, Calls made: 0, Calls completed: 0, People on elevator:1\n" +
                "-1\t0\t█\t2\t3\t4\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 2, Calls made: 0, Calls completed: 1, People on elevator:0\n" +
                "-1\t0\t1\t█\t3\t4\t5\t6\t7\t8\t]");
    }

    /**
     * This method tests for the correct behaviour of a simulation of a call going down
     */
    @Test
    public void SimulationCallGoingDOWN() {
        ElevatorSimulator simulator = new ElevatorSimulator(building, 3, 2);
        simulator.elevatorCall(5, 1);
        simulator.simulate();
        assertEquals(simulator.printActions(), "[\n" +
                "Elevator at floor 3, Calls made: 0, Calls completed: 0, People on elevator:0\n" +
                "-1\t0\t1\t2\t█\t4\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 4, Calls made: 0, Calls completed: 0, People on elevator:0\n" +
                "-1\t0\t1\t2\t3\t█\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 5, Calls made: 1, Calls completed: 0, People on elevator:1\n" +
                "-1\t0\t1\t2\t3\t4\t█\t6\t7\t8\t, \n" +
                "Elevator at floor 4, Calls made: 0, Calls completed: 0, People on elevator:1\n" +
                "-1\t0\t1\t2\t3\t█\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 3, Calls made: 0, Calls completed: 0, People on elevator:1\n" +
                "-1\t0\t1\t2\t█\t4\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 2, Calls made: 0, Calls completed: 0, People on elevator:1\n" +
                "-1\t0\t1\t█\t3\t4\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 1, Calls made: 0, Calls completed: 1, People on elevator:0\n" +
                "-1\t0\t█\t2\t3\t4\t5\t6\t7\t8\t]");
    }

    /**
     * This method tests for the correct behaviour of a simulation of a call when the elevator is already full
     */
    @Test
    public void SimulationWithElevatorOvercrowding() {
        ElevatorSimulator simulator = new ElevatorSimulator(building, 3, 1);
        simulator.elevatorCall(5, 1);
        simulator.elevatorCall(4, 3);
        simulator.simulate();
        assertEquals(simulator.printActions(), "[\n" +
                "Elevator at floor 3, Calls made: 0, Calls completed: 0, People on elevator:0\n" +
                "-1\t0\t1\t2\t█\t4\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 4, Calls made: 1, Calls completed: 0, People on elevator:1\n" +
                "-1\t0\t1\t2\t3\t█\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 5, Calls made: 0, Calls completed: 0, People on elevator:1, Skipped calls(due to exceeding the weight limit): 1\n" +
                "-1\t0\t1\t2\t3\t4\t█\t6\t7\t8\t, \n" +
                "Elevator at floor 4, Calls made: 0, Calls completed: 0, People on elevator:1\n" +
                "-1\t0\t1\t2\t3\t█\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 3, Calls made: 0, Calls completed: 1, People on elevator:0\n" +
                "-1\t0\t1\t2\t█\t4\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 2, Calls made: 0, Calls completed: 0, People on elevator:0\n" +
                "-1\t0\t1\t█\t3\t4\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 3, Calls made: 0, Calls completed: 0, People on elevator:0\n" +
                "-1\t0\t1\t2\t█\t4\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 4, Calls made: 0, Calls completed: 0, People on elevator:0\n" +
                "-1\t0\t1\t2\t3\t█\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 5, Calls made: 1, Calls completed: 0, People on elevator:1\n" +
                "-1\t0\t1\t2\t3\t4\t█\t6\t7\t8\t, \n" +
                "Elevator at floor 4, Calls made: 0, Calls completed: 0, People on elevator:1\n" +
                "-1\t0\t1\t2\t3\t█\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 3, Calls made: 0, Calls completed: 0, People on elevator:1\n" +
                "-1\t0\t1\t2\t█\t4\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 2, Calls made: 0, Calls completed: 0, People on elevator:1\n" +
                "-1\t0\t1\t█\t3\t4\t5\t6\t7\t8\t, \n" +
                "Elevator at floor 1, Calls made: 0, Calls completed: 1, People on elevator:0\n" +
                "-1\t0\t█\t2\t3\t4\t5\t6\t7\t8\t]");
    }

    /**
     * This method tests for the correct behaviour of a single step of a simulation
     */
    @Test
    public void SimulateAStep() {
        ElevatorSimulator simulator = new ElevatorSimulator(building, 3, 2);
        simulator.elevatorCall(5, 1);
        String step=simulator.simulateAStep("");
        assertEquals(step, "\n" +
                "Elevator at floor 3, Calls made: 0, Calls completed: 0, People on elevator:0\n" +
                "-1\t0\t1\t2\t█\t4\t5\t6\t7\t8\t");
    }

    /**
     * This method tests for the correct behaviour of a step of a simulation, but calling an emergency call
     */
    @Test
    public void SimulateAStepWithEmergencyStop() {
        ElevatorSimulator simulator = new ElevatorSimulator(building, 3, 2);
        simulator.elevatorCall(3, 1);
        String step=simulator.simulateAStep("d");
        assertEquals(step, "\n" +
                "Elevator at floor 3, Calls made: 1, Calls completed: 0, People on elevator:1\n" +
                "-1\t0\t1\t2\t█\t4\t5\t6\t7\t8\t");
         step=simulator.simulateAStep("HElp");
        assertEquals(step, "\n" +
                "Elevator at floor 2, Calls made: 0, Calls completed: 0, People on elevator:0\n" +
                "-1\t0\t1\t█\t3\t4\t5\t6\t7\t8\t");
    }
}
