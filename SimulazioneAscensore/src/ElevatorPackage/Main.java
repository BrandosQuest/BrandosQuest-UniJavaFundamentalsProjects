package ElevatorPackage;

import mylib.InputDatiB;
import mylib.MenuB;


public class Main {
    public static void main(String[] args){//remove throws

        ElevatorSimulator simulator;
        greetings();
        simulator=simulatorStartUp();


        // check if the objectSaves dir is created after the download of project
        //make all methods private or the right one
        // don't use d for default but enter


        System.out.println(simulator);
        simulatorCalls(simulator);
        //serializeDataOut(simulator);

    }
    public static void greetings(){
        System.out.println("ELEVATOR SIMULATOR!!!");
    }
    public static ElevatorSimulator simulatorStartUp(){
        MenuB menuB = new MenuB("loading options", new String[] {"Load from text file","Load from a saved simulation", "Manual mode"});
        menuB.printMenuPlusQuit();
        int choice=InputDatiB.nextInt(0, 3, 3);
        ElevatorSimulator simulator = null;
        switch(choice){
            case 1:
                simulator = SimulatorFileUtils.textFileStartUp();
                if(simulator==null){
                    simulator = manualStartUp();
                }
                break;
            case 2:
                simulator = SimulatorFileUtils.savedStartUp();
                if(simulator==null){
                    simulator = manualStartUp();
                }
                break;
            case 3:
                simulator = manualStartUp();
                break;
            default:
                System.out.println("Quitting");
                System.exit(0);
                break;
        }
        return simulator;
    }
    public static ElevatorSimulator manualStartUp(){//look at the order of the inputs and at people load, could be problematic
        System.out.println("MANUAL MODE");
        Building building = new Building(InputDatiB.nextInt(10, "enter the number of floors of the building - at least 10"),//improve this  line, with handling for inputs ad 1 1
                InputDatiB.nextInt(0,10, "enter the number of underground floors of the building - no more than 10"));//improve this  line, with limits to the input
        ElevatorSimulator simulator = new ElevatorSimulator
                (building,
                        InputDatiB.nextInt(building.getLowestFloor(), building.getHighestFloor(),
                                "enter the starting floor of the elevator"+" - between "+building.getLowestFloor()+" and "+building.getHighestFloor()),
                        InputDatiB.nextInt(1, "enter the maximum people load of the elevator - at least 1"));
        if (InputDatiB.nextStringLine("Do you want to save the current state of the simulation? (y/n)").equalsIgnoreCase("y")){
            SimulatorFileUtils.saveSimulation(simulator);
        }
        return simulator;
    }
    public static void simulatorCalls(ElevatorSimulator simulator){
        MenuB menuB = new MenuB("ELEVATORCALLS",new String[]{"enter new elevator call", "save the current state of the simulation"});
        menuB.printMenuPlusQuit();
        int choice=InputDatiB.nextInt(0, 2);
        while (choice!=0){
            switch (choice){
                case 1:
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
                    break;
                case 2:
                    SimulatorFileUtils.saveSimulation(simulator);
                    break;
                default:break;
            }
            menuB.printMenuPlusQuit();
            choice=InputDatiB.nextInt(0, 2);
       }
    }
}