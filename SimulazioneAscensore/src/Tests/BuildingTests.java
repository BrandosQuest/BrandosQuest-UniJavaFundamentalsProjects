package Tests;

import ElevatorPackage.Building;


import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The BuildingTests class, containing the junit tests
 * @author brando
 */
public class BuildingTests {

    /**
     * This method tests for the correct behaviour of the constructor, and the correct errors in case of bad parameters
     */
    @Test
    public void Constructor() {
        Building b = new Building(10, 1);
        assertNotNull(b);
        assertThrows(IllegalArgumentException.class, () -> {
            new Building(1, 1);
        });
    }

    /**
     * This method tests for the correct behaviour of setters and getters and logic methods
     */
    @Test
    public void Methods() {
        Building b = new Building(100, 1);
        assertEquals(98, b.getHighestFloor());
        assertEquals(-1, b.getLowestFloor());
    }
}
