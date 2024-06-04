package ElevatorPackage;

import java.util.Queue;

public class Elevator {
    int maxPeopleLoad;
    int position;
    Building building;

    public Elevator(int maxPeopleLoad, int position, Building building) {
        if(!(position>=building.getLowestFloor() && position<=building.getHighestFloor())){
            throw new IllegalArgumentException("Elevator position is out of bounds in respect to the building floors numbers");
        }
        this.maxPeopleLoad = maxPeopleLoad;
        this.position = position;
        this.building = building;
    }
}
