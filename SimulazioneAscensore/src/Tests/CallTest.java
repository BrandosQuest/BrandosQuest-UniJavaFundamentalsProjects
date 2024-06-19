package Tests;
import static org.junit.Assert.*;

import ElevatorPackage.Building;
import ElevatorPackage.Call;
import org.junit.Test;
public class CallTest {
    Building building = new Building(10, 1);
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
