package ElevatorPackage;

public class Building {
    int floors;
    int undergroundFloors;
    public Building(int floors, int undergroundFloors) {
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
