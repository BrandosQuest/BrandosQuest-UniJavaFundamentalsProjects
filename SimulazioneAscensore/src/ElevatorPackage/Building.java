package ElevatorPackage;

public class Building {
    private final int floors;
    private final int undergroundFloors;
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

    @Override
    public String toString() {
        return "Building{" +
                "floors=" + floors +
                ", undergroundFloors=" + undergroundFloors +
                '}';
    }
}
