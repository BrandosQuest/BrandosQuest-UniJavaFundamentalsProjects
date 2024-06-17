package ElevatorPackage;

import java.io.Serializable;

public class Call implements Serializable {
    private final int originFloor;
    private final int destinationFloor;
    private Direction direction;
    private boolean onElevator;

    public Call(int originFloor, int destinationFloor, Building building, boolean onElevator) {
        if(!(originFloor>=building.getLowestFloor() && originFloor<=building.getHighestFloor())){
            throw new IllegalArgumentException("Origin floor is out of bounds in respect to the building floors numbers");
        }
        if(!(destinationFloor>=building.getLowestFloor() && destinationFloor<=building.getHighestFloor())){
            throw new IllegalArgumentException("Destination floor is out of bounds in respect to the building floors numbers");
        }
        this.originFloor = originFloor;
        this.destinationFloor = destinationFloor;
        determineDirection();
        this.onElevator = onElevator;
    }

    public void setOnElevator(boolean onElevator) {
        this.onElevator = onElevator;
    }

    public boolean isOnElevator() {
        return onElevator;
    }

    private void determineDirection() {
        if(destinationFloor>originFloor) {
            direction=Direction.UP;
        }else if(destinationFloor<originFloor) {
            direction=Direction.DOWN;
        }else {
            throw new IllegalArgumentException("Origin floor is the same as the destination floor");
        }
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public int getOriginFloor() {
        return originFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "\nCall{" +
                "originFloor=" + originFloor +
                ", destinationFloor=" + destinationFloor +
                ", direction=" + direction +
                ", onElevator=" + onElevator +
                '}';
    }
}
