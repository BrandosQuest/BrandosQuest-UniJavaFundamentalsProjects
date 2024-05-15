package PolveriSottiliPackage;

import java.util.Arrays;

/**
 * Class used to represent a week and its fine dust levels for every day
 *
 * @author brando
 */
public class Week {
    /**
     * the year of the week considered
     */
    private int year;
    /**
     * the week number of the week considered
     */
    private int weekNumber;
    /**
     * the dest levels of the week considered
     */
    private int[] dustLevels;


    /**Constructor of the Week class
     * @param year the year of the week considered
     * @param weekNumber the week number of the week considered
     * @param dustLevels the dest levels of the week considered
     * @throws IllegalArgumentException Exception used to ensure no week can be created with wrong attributes
     */
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

    /**
     * @return the highest value of fine dust level in the week
     */
    private int getMaxDustLevel() {
        int maxDustLevel = 0;
        for (int dustLevel : dustLevels) {
            if (dustLevel > maxDustLevel) {
                maxDustLevel = dustLevel;
            }
        }
        return maxDustLevel;
    }

    /**
     * @return the mean of the value of fine dust levels in the week
     */
    private int getMeanDustLevel() {
        int meanDustLevel = 0;
        for (int dustLevel : dustLevels) {
            meanDustLevel += dustLevel;
        }
        return meanDustLevel/dustLevels.length;
    }

    /**
     * utility method, called when you want to make a check of the week dust levels
     */
    public void checkWeekDustLevels(){
        MaxDustLevelOutOfBound();
        MeanDustLevelOutOfBound();
    }

    /**method to check if the max dust level is out of bounds
     * @return the boolean answer
     */
    public boolean MaxDustLevelOutOfBound(){
        if(getMaxDustLevel()>=75){
            System.out.println("Warning: found highest value of fine dust particle of "+getMaxDustLevel()+" because it was higher than 75 µg/m^3");
         return true;
        }
        return false;
    }

    /**method to check if the mean dust level is out of bounds
     * @return the boolean answer
     */
    public boolean MeanDustLevelOutOfBound(){
        if(getMeanDustLevel()>=50){
            System.out.println("Warning: mean of fine dust particle in the week exceeds 50 µg/m^3 at the value of "+getMeanDustLevel());
            return true;
        }
        return false;
    }

    /**ToString of the week
     * @return the week representation as a string
     */
    @Override
    public String toString() {
        return "---------\nWeek{" +
                "year=" + year +
                ", weekNumber=" + weekNumber +
                ", dustLevels=" + Arrays.toString(dustLevels) +
                "}\n---------";
    }
}
