package ElevatorPackage;

import java.util.Queue;

public class Elevator {
    int position;
    Building building;
    int maxPeopleLoad;

    public Elevator(int maxPeopleLoad, int position, Building building) {
        if(!(position>=building.getLowestFloor() && position<=building.getHighestFloor())){
            throw new IllegalArgumentException("Elevator position is out of bounds in respect to the building floors numbers");
        }
        this.maxPeopleLoad = maxPeopleLoad;
        this.position = position;
        this.building = building;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "position=" + position +
                ", building=" + building +
                ", maxPeopleLoad=" + maxPeopleLoad +
                '}';
    }
}
