package ElevatorPackage;


import java.io.Serializable;

public class Elevator implements Serializable {
    private final int position;
    private final int maxPeopleLoad;
    private final int peopleLoad;

    public Elevator(Building building, int position, int maxPeopleLoad) {
        if(!(position>= building.getLowestFloor() && position<= building.getHighestFloor())){
            throw new IllegalArgumentException("Elevator position is out of bounds in respect to the building floors numbers");
        }
        this.position = position;
        this.maxPeopleLoad = maxPeopleLoad;
        this.peopleLoad=0;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "position=" + position +
                ", maxPeopleLoad=" + maxPeopleLoad +
                '}';
    }
}
