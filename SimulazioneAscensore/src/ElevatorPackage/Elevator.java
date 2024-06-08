package ElevatorPackage;


import java.io.Serializable;

public class Elevator implements Serializable {
    private final int position;
    private final int maxPeopleLoad;

    public Elevator(int maxPeopleLoad, int position, int lowestFloor, int highestFloor) {
        if(!(position>=lowestFloor && position<=highestFloor)){
            throw new IllegalArgumentException("Elevator position is out of bounds in respect to the building floors numbers");
        }
        this.maxPeopleLoad = maxPeopleLoad;
        this.position = position;

    }

    @Override
    public String toString() {
        return "Elevator{" +
                "position=" + position +
                ", maxPeopleLoad=" + maxPeopleLoad +
                '}';
    }
}
