package ElevatorPackage;

public class Building {
    int floors;
    int undergroundFloors;
    public Building(int floors, int undergroundFloors) {
        if (floors < 10){
            throw new IllegalArgumentException("At least 10 floors are required");
        }
        this.floors = floors;
        this.undergroundFloors = undergroundFloors;
    }
    public int getHighestFloor() {
        return floors-undergroundFloors;
    }
    public int getLowestFloor() {
        return -undergroundFloors;
    }
}
