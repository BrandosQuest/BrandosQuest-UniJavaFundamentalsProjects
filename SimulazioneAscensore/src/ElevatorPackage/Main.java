package ElevatorPackage;

import mylib.InputDatiB;
import mylib.MenuB;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {//remove throws
        //ElevatorSimulator s = serializeDataIn();
        //System.out.println(s);
        ElevatorSimulator simulator;
        greetings();
        simulator=simulatorStartUp();
        System.out.println(simulator);
        simulatorCalls(simulator);
        //serializeDataOut(simulator);

    }
    public static void greetings(){
        System.out.println("ELEVATOR SIMULATOR!!!");
    }
    public static ElevatorSimulator simulatorStartUp(){
        Building building = new Building(InputDatiB.nextInt(10, "enter the number of floors of the building - at least 10"),//improve this  line, with handling for inputs ad 1 1
                InputDatiB.nextInt(0,10, "enter the number of underground floors of the building - no more than 10"));//improve this  line, with limits to the input
        int maxPeopleLoad = InputDatiB.nextInt(1, "enter the maximum people load of the elevator - at least 1");
        return new ElevatorSimulator
                (building,
                maxPeopleLoad,
                InputDatiB.nextInt(building.getLowestFloor(), building.getHighestFloor(),
                        "enter the starting floor"+" - between "+building.getLowestFloor()+" and "+building.getHighestFloor()),
                InputDatiB.nextInt(0, maxPeopleLoad, "enter the people load of the elevator"+" - between "+0+" and "+maxPeopleLoad));
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
    public static void serializeDataOut(ElevatorSimulator simulator)throws IOException {
        File f = new File("Test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(f)));
        objectOutputStream.writeObject(simulator);
        objectOutputStream.close();
    }
    public static ElevatorSimulator serializeDataIn() throws IOException, ClassNotFoundException {
        File f = new File("Test.txt");
        ObjectInputStream objectOutputStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(f)));
        ElevatorSimulator s = (ElevatorSimulator) objectOutputStream.readObject();
        objectOutputStream.close();
        return s;
    }
}