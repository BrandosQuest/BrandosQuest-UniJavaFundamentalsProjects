package Tests;

import ElevatorPackage.Building;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingTests {
    @Test
    public void Constructor() {
        Building b = new Building(10, 1);
        assertNotNull(b);
        assertThrows(IllegalArgumentException.class, () -> {
            new Building(1, 1);
        });
    }
    @Test
    public void Methods() {
        Building b = new Building(100, 1);
        assertEquals(98, b.getHighestFloor());
        assertEquals(-1, b.getLowestFloor());
    }
}
