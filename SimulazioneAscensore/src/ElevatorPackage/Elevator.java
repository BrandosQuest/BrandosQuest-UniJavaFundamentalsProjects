package ElevatorPackage;


import java.io.Serializable;

public class Elevator implements Serializable {
    private final int position;
    private final int maxPeopleLoad;
    private final int PeopleLoad;

    public Elevator(int maxPeopleLoad, int peopleLoad, int position, Building building) {
        if(!(position>= building.getLowestFloor() && position<= building.getHighestFloor())){
            throw new IllegalArgumentException("Elevator position is out of bounds in respect to the building floors numbers");
        }
        this.position = position;
        this.maxPeopleLoad = maxPeopleLoad;
        if(peopleLoad>maxPeopleLoad){
            throw new IllegalArgumentException("Elevator load is out of bounds in respect to the max people load given");
        }
        PeopleLoad = peopleLoad;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "position=" + position +
                ", maxPeopleLoad=" + maxPeopleLoad +
                '}';
    }
}
