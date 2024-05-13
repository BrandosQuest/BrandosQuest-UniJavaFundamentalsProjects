package PolveriSottiliPackage;

import java.util.Arrays;

/**
 * Class used to represent a week and its fine dust levels for every day
 *
 * @author brando
 */
public class Week {
    private int year;
    private int weekNumber;
    private int[] dustLevels;

    public Week(int year, int weekNumber, int[] dustLevels) throws IllegalArgumentException{
        if (year>=1800) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Year must be set to after 1800 AD");
        }
        if (weekNumber>=1 && weekNumber<=53) {
            this.weekNumber = weekNumber;
        } else {
            throw new IllegalArgumentException("Week's number must be comprised between 1 and 53");
        }
        if (dustLevels.length==7) {
            this.dustLevels = dustLevels;
        } else {
            throw new IllegalArgumentException("Not enough or too many dust levels provided for a single week");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public int[] getDustLevels() {
        return dustLevels;
    }

    public void setDustLevels(int[] dustLevels) {
        this.dustLevels = dustLevels;
    }

    private int getMaxDustLevel() {
        int maxDustLevel = 0;
        for (int dustLevel : dustLevels) {
            if (dustLevel > maxDustLevel) {
                maxDustLevel = dustLevel;
            }
        }
        return maxDustLevel;
    }

    private int getMeanDustLevel() {
        int meanDustLevel = 0;
        for (int dustLevel : dustLevels) {
            meanDustLevel += dustLevel;
        }
        return meanDustLevel/dustLevels.length;
    }

    public void checkWeekDustLevels(){
        MaxDustLevelOutOfBound();
        MeanDustLevelOutOfBound();
    }
    public boolean MaxDustLevelOutOfBound(){
        if(getMaxDustLevel()>=75){
            System.out.println("Warning: found highest value of fine dust particle of "+getMaxDustLevel()+" because it was higher than 75 µg/m^3");
         return true;
        }
        return false;
    }
    public boolean MeanDustLevelOutOfBound(){
        if(getMeanDustLevel()>=50){
            System.out.println("Warning: mean of fine dust particle in the week exceeds 50 µg/m^3 at the value of "+getMeanDustLevel());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "---------\nWeek{" +
                "year=" + year +
                ", weekNumber=" + weekNumber +
                ", dustLevels=" + Arrays.toString(dustLevels) +
                "}\n---------";
    }
}
