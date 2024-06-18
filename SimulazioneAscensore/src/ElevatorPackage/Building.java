package ElevatorPackage;

import java.io.Serializable;

/**
 * The class that represents a Building
 * Implements the Serializable interface to enable this class to be saved
 * @author brando
 */
public class Building implements Serializable {
    /**
     * the total number of floors of the building
     */
    private final int floors;
    /**
     * the number of underground floors of the building
     */
    private final int undergroundFloors;

    /**Constructor of Building
     * @param floors the total number of floors of the building
     * @param undergroundFloors the number of underground floors of the building
     * @throws IllegalArgumentException if the floors are less than 10
     */
    public Building(int floors, int undergroundFloors) {
        if (floors < 10){
            throw new IllegalArgumentException("At least 10 floors are required");
        }
        this.floors = floors;
        this.undergroundFloors = undergroundFloors;
    }

    /**method used to calculate the Highest Floor
     * @return the Highest Floor of the building
     */
    public int getHighestFloor() {
        return floors-undergroundFloors-1;//check if -1 is ok
    }

    /**method used to calculate the Lowest Floor
     * @return the Lowest Floor of the building
     */
    public int getLowestFloor() {
        return -undergroundFloors;
    }

    /**ToString method of Building
     * @return A string representing the current state of the Building
     */
    @Override
    public String toString() {
        return "Building{" +
                "floors=" + floors +
                ", undergroundFloors=" + undergroundFloors +
                '}';
    }
}
