package ElevatorPackage;

import java.io.Serializable;

/**
 * The class that represents a Call
 * Implements the Serializable interface to enable this class to be saved
 * @author brando
 */
public class Call implements Serializable {
    /**
     * the floor number of where the call was made
     */
    private int originFloor;
    /**
     * the floor number of where the call will be completed
     */
    private final int destinationFloor;
    /**
     * the Direction of the call
     */
    private Direction direction;
    /**
     * the flag indicating if the pearson who made the call is on the elevator
     */
    private boolean onElevator;
    /**
     * the flag indicating if the call was skipped by the elevator due to exceeding the max people load
     */
    private boolean skipped;

    /**Constructor of the Call class
     * @param originFloor the floor number of where the call was made
     * @param destinationFloor the floor number of where the call will be completed
     * @param building the building object used to check for the consistency of the floors in regard to the building
     * @throws IllegalArgumentException if the floors are inconsistent with the building
     */
    public Call(int originFloor, int destinationFloor, Building building) {
        if(!(originFloor>=building.getLowestFloor() && originFloor<=building.getHighestFloor())){
            throw new IllegalArgumentException("Origin floor is out of bounds in respect to the building floors numbers");
        }
        if(!(destinationFloor>=building.getLowestFloor() && destinationFloor<=building.getHighestFloor())){
            throw new IllegalArgumentException("Destination floor is out of bounds in respect to the building floors numbers");
        }
        this.originFloor = originFloor;
        this.destinationFloor = destinationFloor;
        determineDirection();
        this.onElevator = false;
    }

    /**Setter of onElevator flag
     * @param onElevator the boolean representing the state of the flag
     */
    public void setOnElevator(boolean onElevator) {
        this.onElevator = onElevator;
    }

    /**Getter of onElevator flag
     * @return the boolean representing the state of the flag
     */
    public boolean isOnElevator() {
        return onElevator;
    }

    /**Setter of skipped flag
     * @param skipped the boolean representing the state of the flag
     */
    public void setSkipped(boolean skipped) {
        this.skipped = skipped;
    }

    /**Getter of skipped flag
     * @return the inverse of the boolean representing the state of the flag
     */
    public boolean wasNotSkipped() {
        return !skipped;
    }

    /**
     * Method used to calculate the direction that this call would move the elevator
     * @throws IllegalArgumentException if the Origin floor is the same as the destination floor
     */
    private void determineDirection() {
        if(destinationFloor>originFloor) {
            direction=Direction.UP;
        }else if(destinationFloor<originFloor) {
            direction=Direction.DOWN;
        }else {
            throw new IllegalArgumentException("Origin floor is the same as the destination floor");
        }
    }

    /**Getter of destinationFloor
     * @return the int representing the destinationFloor
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }

    /**Getter of originFloor
     * @return the int representing the originFloor
     */
    public int getOriginFloor() {
        return originFloor;
    }

    /**Setter of originFloor
     * @param originFloor the int representing the originFloor
     */
    public void setOriginFloor(int originFloor) {
        this.originFloor = originFloor;
    }

    /**ToString method of Call
     * @return A string representing the current state of the Call
     */
    @Override
    public String toString() {
        return "\nCall{" +
                "originFloor=" + originFloor +
                ", destinationFloor=" + destinationFloor +
                ", direction=" + direction +
                //", onElevator=" + onElevator +
                //", skipped=" + skipped +
                '}';
    }
}
