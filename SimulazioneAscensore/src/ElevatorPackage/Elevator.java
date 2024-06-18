package ElevatorPackage;

import java.io.Serializable;

/**
 * The class that represents the Elevator
 * Implements the Serializable interface to enable this class to be saved
 * @author brando
 */
public class Elevator implements Serializable {
    /**
     * The position of the elevator
     */
    private int position;
    /**
     * The maximum load of the elevator
     */
    private final int maxPeopleLoad;
    /**
     * The load of the elevator
     */
    private int peopleLoad;

    /**Constructor of the Elevator, checks for the consistency of the position in regard to the building
     * @param building the building object used to check for the consistency of the position in regard to the building
     * @param position the initial position
     * @param maxPeopleLoad The maximum load of the elevator
     * @throws IllegalArgumentException if the Elevator position is out of bounds in respect to the building floors numbers or The max people load is less than 1, must be greater
     */
    public Elevator(Building building, int position, int maxPeopleLoad) {
        if(!(position>= building.getLowestFloor() && position<= building.getHighestFloor())){
            throw new IllegalArgumentException("Elevator position is out of bounds in respect to the building floors numbers");
        }
        if(maxPeopleLoad<1){
            throw new IllegalArgumentException("The max people load is less than 1, must be greater");
        }
        this.position = position;
        this.maxPeopleLoad = maxPeopleLoad;
        this.peopleLoad=0;
    }

    /**getter of the position attribute
     * @return the integer representing the position
     */
    public int position() {
        return position;
    }

    /**This method moves the elevator, by incrementing or decrementing its position
     * @param direction the Direction Enum value for the direction
     */
    public void moveOneFloor(Direction direction) {
        if(direction == Direction.UP){
            position++;
        }else {
            position--;
        }
    }

    /**getter of people load
     * @return the people load of the elevator
     */
    public int getPeopleLoad() {
        return peopleLoad;
    }

    /**getter of max people load
     * @return the max people load of the elevator
     */
    public int getMaxPeopleLoad() {
        return maxPeopleLoad;
    }

    /**setter of people load
     * @param peopleLoad the signed integer representing how many people we are adding or subtracting from the elevator
     * @throws IllegalArgumentException if we add or subtract too many people
     */
    public void setPeopleLoad(int peopleLoad) throws IllegalArgumentException{
        if(this.peopleLoad+peopleLoad>maxPeopleLoad || this.peopleLoad+peopleLoad<0){
            //this.peopleLoad--;
            throw new IllegalArgumentException("Elevator load "+(this.peopleLoad+peopleLoad)+" is out of bounds in respect to the maximum people load "+maxPeopleLoad);
        }
        this.peopleLoad = this.peopleLoad+peopleLoad;
    }

    /**ToString method of Elevator
     * @return A string representing the current state of the Elevator
     */
    @Override
    public String toString() {
        return "Elevator{" +
                "position=" + position +
                ", maxPeopleLoad=" + maxPeopleLoad +
                ", peopleLoad=" + peopleLoad +
                '}';
    }
}
