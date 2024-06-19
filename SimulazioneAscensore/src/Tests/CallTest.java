package Tests;
import static org.junit.Assert.*;

import ElevatorPackage.Building;
import ElevatorPackage.Call;
import org.junit.Test;

/**
 * The CallTest class, containing the junit tests
 * @author brando
 */
public class CallTest {
    /**
     * The Building object, tested in the BuildingTests class, used to initiate the objects tested
     */
    private final Building building = new Building(10, 1);

    /**
     * This method tests for the correct behaviour of the constructor, and the correct errors in case of bad parameters
     */
    @Test
    public void Constructor() {
        Call call = new Call(-1, 3, building);
        assertNotNull(call);
        assertThrows(IllegalArgumentException.class, () -> {
            new Call(-11, 3, building);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Call(-1, 199, building);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Call(111, 2, building);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Call(1, -22, building);
        });
    }

    /**
     * This method tests for the correct behaviour of setters and getters and logic methods
     */
    @Test
    public void Methods() {
        Call call = new Call(-1, 3, building);
        call.setOnElevator(true);
        assertTrue(call.isOnElevator());
        call.setSkipped(true);
        assertFalse(call.wasNotSkipped());
        assertEquals(-1, call.getOriginFloor());
        assertEquals(3, call.getDestinationFloor());
        call.setOriginFloor(1);
        assertEquals(1, call.getOriginFloor());
    }
}
