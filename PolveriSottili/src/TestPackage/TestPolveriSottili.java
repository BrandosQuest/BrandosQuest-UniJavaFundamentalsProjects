package TestPackage;

import PolveriSottiliPackage.Week;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Test class for the Polveri Sottili project, made under the directions of the guide
 *
 * @author Brando
 */
public class TestPolveriSottili {

    /**
     * Tests if there's no triggering of MaxDustLevelOutOfBound and MeanDustLevelOutOfBound with normal inputs
     */
    @Test
    public void noDangerousLevelOfDust() {
        Week week = new Week(2020, 13, new int[]{1, 1, 1, 1, 1, 1, 1});
        assertFalse(week.MaxDustLevelOutOfBound());
        assertFalse(week.MeanDustLevelOutOfBound());
    }
    /**
     * Tests if there's triggering of MaxDustLevelOutOfBound and MeanDustLevelOutOfBound with abnormal inputs
     */
    @Test
    public void allDangerousLevelOfDust() {
        Week week = new Week(2020, 13, new int[]{100, 100, 100, 100, 100, 100, 100});
        assertTrue(week.MaxDustLevelOutOfBound());
        assertTrue(week.MeanDustLevelOutOfBound());
    }
    /**
     * Tests if there's triggering of MaxDustLevelOutOfBound and not of MeanDustLevelOutOfBound with one abnormal input
     */
    @Test
    public void oneDangerousLevelOfDust() {
        Week week = new Week(2020, 13, new int[]{1, 1, 1, 1, 100, 1, 1});
        assertTrue(week.MaxDustLevelOutOfBound());
        assertFalse(week.MeanDustLevelOutOfBound());
    }
    /**
     * Tests if there's  triggering of MeanDustLevelOutOfBound and not of MaxDustLevelOutOfBound with all higher than average inputs
     */
    @Test
    public void DangerousMeanLevelOfDust() {
        Week week = new Week(2020, 13, new int[]{53, 51, 74, 64, 72, 71, 59});
        assertFalse(week.MaxDustLevelOutOfBound());
        assertTrue(week.MeanDustLevelOutOfBound());
    }
}
