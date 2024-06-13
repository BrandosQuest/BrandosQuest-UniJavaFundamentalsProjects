package ElevatorPackage;

import mylib.InputDatiB;
import mylib.MenuB;
import java. util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {//remove throws
        //ElevatorSimulator s = serializeDataIn();
        //System.out.println(s);
        ElevatorSimulator simulator;
        greetings();
        simulator=simulatorStartUp();

        // check if the objectSaves dir is created after the download of project


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
                simulator = textFileStartUp();
                break;
            case 2:
                simulator = savedStartUp();
                break;
            case 3:
                simulator = manualStartUp();
                if (InputDatiB.nextStringLine("Do you want to save the current state of te simulation? (y/n)").equalsIgnoreCase("y")){
                    saveSimulation(simulator);
                }
                break;
            default:
                System.out.println("Quitting");
                System.exit(0);
                break;
        }


        return simulator;
    }

    public static ElevatorSimulator textFileStartUp(){
        System.out.println("LOADING FROM TEXT FILE");
        return null;
    }
    public static ElevatorSimulator savedStartUp(){
        System.out.println("LOADING FROM PAST SAVED SIMULATION");
        String name = InputDatiB.nextStringLine("enter the name of the saved simulation");
        ElevatorSimulator simulator = null;
        File f = new File("saves/objectSaves/"+name+".txt");

        try {
            ObjectInputStream objectOutputStream = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(f)));
            simulator = (ElevatorSimulator) objectOutputStream.readObject();
            objectOutputStream.close();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error in reading the file, going into manual mode");
            simulator = manualStartUp();
        }

        return simulator;
    }
    public static ElevatorSimulator manualStartUp(){//look at the order of the inputs and at people load, could be problematic
        System.out.println("MANUAL MODE");
        Building building = new Building(InputDatiB.nextInt(10, "enter the number of floors of the building - at least 10"),//improve this  line, with handling for inputs ad 1 1
                InputDatiB.nextInt(0,10, "enter the number of underground floors of the building - no more than 10"));//improve this  line, with limits to the input
        int maxPeopleLoad = InputDatiB.nextInt(1, "enter the maximum people load of the elevator - at least 1");
        return new ElevatorSimulator
                (building,
                        maxPeopleLoad,
                        InputDatiB.nextInt(building.getLowestFloor(), building.getHighestFloor(),
                                "enter the starting floor of the elevator"+" - between "+building.getLowestFloor()+" and "+building.getHighestFloor()),
                        InputDatiB.nextInt(0, maxPeopleLoad, "enter the people load of the elevator"+" - between "+0+" and "+maxPeopleLoad));
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
                    saveSimulation(simulator);
                    break;
                default:break;
            }
            menuB.printMenuPlusQuit();
            choice=InputDatiB.nextInt(0, 2);
       }
    }
    public static void saveSimulation(ElevatorSimulator simulator){
        System.out.println("SAVING CURRENT SIMULATION");
        String name = InputDatiB.nextStringLine("enter a name for the save or D to use the default \"save+numberSave\"");

        File savingFile=null;
        if(name.equalsIgnoreCase("d")){
            File f = new File("saves/objectSaves");
            String[] s = f.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return dir.getName().startsWith("save") && dir.getName().endsWith("\\d");
                }
            });
            int max=0;
            for (int i = 0; i < s.length; i++) {
                s[i]=s[i].substring(3);
                if(Integer.parseInt(s[i])>max){
                    max=Integer.parseInt(s[i]);
                }
            }
            savingFile = new File("saves/objectSaves/save"+max+".txt");
        }else{
            savingFile = new File("saves/objectSaves/"+name+".txt");
        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(savingFile)));
            objectOutputStream.writeObject(simulator);
            objectOutputStream.close();
            System.out.println("Save successful");
        } catch (IOException e){
            System.out.println("Save failed\n"+e.getMessage());
        }
    }
}