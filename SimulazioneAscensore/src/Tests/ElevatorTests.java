package Tests;

import ElevatorPackage.Building;
import ElevatorPackage.Direction;
import ElevatorPackage.Elevator;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The ElevatorTests class, containing the junit tests
 * @author brando
 */
public class ElevatorTests {
    /**
     * The Building object, tested in the BuildingTests class, used to initiate the objects tested
     */
    private final Building building = new Building(10, 1);

    /**
     * This method tests for the correct behaviour of the constructor, and the correct errors in case of bad parameters
     */
    @Test
    public void Constructor() {
        Elevator elevator = new Elevator(building, 3, 3);
        assertNotNull(elevator);
        assertThrows(IllegalArgumentException.class, () -> {
            new Elevator(building, 10, 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Elevator(building, 3, -14);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Elevator(building, -15, 3);
        });
    }

    /**
     * This method tests for the correct behaviour of setters and getters and logic methods
     */
    @Test
    public void Methods() {
        Elevator elevator = new Elevator(building, 3, 3);
        assertEquals(3, elevator.position());
        elevator.moveOneFloor(Direction.UP);
        assertEquals(4, elevator.position());
        assertEquals(3, elevator.getMaxPeopleLoad());
        elevator.setPeopleLoad(1);
        assertEquals(1, elevator.getPeopleLoad());
        assertThrows(IllegalArgumentException.class, () -> {
            elevator.setPeopleLoad(11);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            elevator.setPeopleLoad(-11);
        });
    }
}
