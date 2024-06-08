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
        Building building = new Building(InputDatiB.nextInt(10, "enter the number of floors of the building - at least 10"),
                InputDatiB.nextInt(0,10, "enter the number of underground floors of the building - no more than 10"));
        ElevatorSimulator simulator= new ElevatorSimulator
                (building,
                InputDatiB.nextInt(1, "enter the maximum people load of the elevator"),
                InputDatiB.nextInt(building.getLowestFloor(), "enter the starting floor"));//improve this  line, with limits to the input
        return simulator;
    }
    public static void simulatorCalls(ElevatorSimulator simulator){
        MenuB menuB = new MenuB("ELEVATORCALLS",new String[]{"enter new elevator call"});
        menuB.printMenuPlusQuit();
        int choice=InputDatiB.nextInt(0);
        while (choice!=0){
            simulator.elevatorCall(InputDatiB.nextInt(0,"enter the floor of the call"), //improve this 2 lines, with limits to the imputs
            InputDatiB.nextInt(0,"enter the destination floor of the call"));
            menuB.printMenuPlusQuit();
            choice=InputDatiB.nextInt(0);
       }
    }
    }