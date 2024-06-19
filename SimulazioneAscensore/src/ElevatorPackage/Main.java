package ElevatorPackage;

import mylib.InputDatiB;
import mylib.MenuB;

/**
 * The Main class of my project, Simulazione Ascensore, containing the runnable main method, all the user inputs occur here
 *
 * @author brando
 */
public class Main {
    /**
     * The runnable method of my project, where the elevator is declared, and the methods for calls and simulating are called
     * @param args the parameters of the main method, where the execution starts
     */
    public static void main(String[] args){
        ElevatorSimulator simulator;
        greetings();
        simulator=simulatorStartUp();


        // check if the objectSaves dir is created after the download of project
        //make all methods private or the right one
        // don't use d for default but enter


        System.out.println(simulator);
        simulatorCalls(simulator);
        String mode=InputDatiB.nextStringLine("Hit any key to simulate or \"s\" to execute a step by step simulation");
        System.out.println("NOW SIMULATING!!!");
        if(mode.equalsIgnoreCase("s")){
            System.out.println("Enter \"help\" for executing an emergency stop");
            String step=" ";
            String command="";
            while (!step.isEmpty()) {
                step=simulator.simulateAStep(command);
                System.out.println(step);
                command=InputDatiB.nextStringLine();
            }
        }else {
            simulator.simulate();
            System.out.println(simulator.printActions());
        }
    }
    /**
     * Greetings for the user
     */
    private static void greetings(){
        System.out.println("ELEVATOR SIMULATOR!!!");
    }
    /**this method returns the instance of ElevatorSimulator where the simulation will be run,
     * it can come from a text file, a saved simulation, or entered step by step by the used
     * @return the initialized instance of ElevatorSimulator
     */
    private static ElevatorSimulator simulatorStartUp(){
        MenuB menuB = new MenuB("loading options", new String[] {"Load from text file","Load from a saved simulation", "Manual mode"});
        menuB.printMenuPlusQuit();
        int choice=InputDatiB.nextInt(0, 3, 3);
        ElevatorSimulator simulator = null;
        switch(choice){
            case 1:
                try {
                    simulator = SimulatorFileUtils.textFileStartUp();
                } catch (Exception e) {
                    System.out.println("An error occurred, fix the text file "+e.getMessage());
                    simulator = manualStartUp();
                }
                if(simulator==null){
                    simulator = manualStartUp();
                }
                break;
            case 2:
                try {
                    simulator = SimulatorFileUtils.savedStartUp();
                } catch (Exception e) {
                    System.out.println("An error occurred, during the reading of the save "+e.getMessage());
                    simulator = manualStartUp();
                }
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

    /**Method that asks the user for the parameters of our simulation, with attention to incorrect inputs,
     * It's the backup for the failing of the loading of a simulator from a save or from a text file
     * @return the initialized instance of ElevatorSimulator
     */
    private static ElevatorSimulator manualStartUp(){
        System.out.println("MANUAL MODE");
        Building building = new Building(InputDatiB.nextInt(10, "enter the number of floors of the building - at least 10"),
                InputDatiB.nextInt(0,10, "enter the number of underground floors of the building - no more than 10"));
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

    /**Method that asks the user for calls of the elevator, using 2 integers as to represent the floor in witch the call is made and the floor to witch is going
     * @param simulator an ElevatorSimulator object, storing the calls for the simulation later
     */
    private static void simulatorCalls(ElevatorSimulator simulator){
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