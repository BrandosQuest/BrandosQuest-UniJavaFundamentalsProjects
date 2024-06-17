package ElevatorPackage;


import java.io.Serializable;

public class Elevator implements Serializable {
    private int position;
    private final int maxPeopleLoad;
    private int peopleLoad;

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
    public int position() {
        return position;
    }
    public void moveOneFloor(Direction direction) {
        if(direction == Direction.UP){
            position++;
        }else {
            position--;
        }
    }

    public int getPeopleLoad() {
        return peopleLoad;
    }

    public int getMaxPeopleLoad() {
        return maxPeopleLoad;
    }

    public void setPeopleLoad(int peopleLoad) throws IllegalArgumentException{
        if(this.peopleLoad+peopleLoad>maxPeopleLoad || this.peopleLoad+peopleLoad<0){
            //this.peopleLoad--;
            throw new IllegalArgumentException("Elevator load "+(this.peopleLoad+peopleLoad)+" is out of bounds in respect to the maximum people load "+maxPeopleLoad);
        }
        this.peopleLoad = this.peopleLoad+peopleLoad;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "position=" + position +
                ", maxPeopleLoad=" + maxPeopleLoad +
                ", peopleLoad=" + peopleLoad +
                '}';
    }
}
