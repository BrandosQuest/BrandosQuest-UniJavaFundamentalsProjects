package TestPackage;

import PolveriSottiliPackage.Week;
import org.junit.*;

import static org.junit.Assert.*;

public class TestPolveriSottili {

    @Test
    public void noDangerousLevelOfDust() {
        Week week = new Week(2020, 13, new int[]{1, 1, 1, 1, 1, 1, 1});
        week.checkWeekDustLevels();
    }
}
