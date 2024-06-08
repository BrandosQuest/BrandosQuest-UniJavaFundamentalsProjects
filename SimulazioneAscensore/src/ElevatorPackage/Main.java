package ElevatorPackage;

import mylib.InputDatiB;
import mylib.MenuB;

public class Main {
    public static void main(String[] args) {
        ElevatorSimulator simulator;
        greetings();
        simulator=simulatorStartUp();
        System.out.println(simulator);
        simulatorCalls(simulator);
    }
    public static void greetings(){
        System.out.println("ELEVATOR SIMULATOR!!!");
    }
    public static ElevatorSimulator simulatorStartUp(){
        Building building = new Building(InputDatiB.nextInt(10, "enter the number of floors of the building - at least 10"),//improve this  line, with handling for inputs ad 1 1
                InputDatiB.nextInt(0,10, "enter the number of underground floors of the building - no more than 10"));//improve this  line, with limits to the input
        ElevatorSimulator simulator= new ElevatorSimulator
                (building,
                InputDatiB.nextInt(1, "enter the maximum people load of the elevator - at least 1"),
                InputDatiB.nextInt(building.getLowestFloor(), building.getHighestFloor(),
                        "enter the starting floor"+" - between "+building.getLowestFloor()+" and "+building.getHighestFloor()));
        return simulator;
    }
    public static void simulatorCalls(ElevatorSimulator simulator){
        MenuB menuB = new MenuB("ELEVATORCALLS",new String[]{"enter new elevator call"});
        menuB.printMenuPlusQuit();
        int choice=InputDatiB.nextInt(0, 1);
        while (choice!=0){
            int originFloor= InputDatiB.nextInt(simulator.getBuilding().getLowestFloor(), simulator.getBuilding().getHighestFloor(),
            "enter the floor of the call"+
                    " - between "+simulator.getBuilding().getLowestFloor()+" and "+simulator.getBuilding().getHighestFloor());
            int destinationFloor;
            do {
                destinationFloor = InputDatiB.nextInt(simulator.getBuilding().getLowestFloor(), simulator.getBuilding().getHighestFloor(),
                "enter the destination floor of the call, different from the origin "+originFloor+
                        " - between "+simulator.getBuilding().getLowestFloor()+" and "+simulator.getBuilding().getHighestFloor());
            } while (destinationFloor==originFloor);
            simulator.elevatorCall(originFloor, destinationFloor);
            System.out.println(simulator);
            menuB.printMenuPlusQuit();
            choice=InputDatiB.nextInt(0, 1);
       }
    }
    }