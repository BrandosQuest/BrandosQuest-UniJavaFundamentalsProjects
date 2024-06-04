package ElevatorPackage;

import mylib.InputDatiB;

public class Main {
    public static void main(String[] args) {
        ElevatorSimulator simulator;
        greetings();
    }
    public static void greetings(){
        System.out.println("ELEVATOR SIMULATOR!!!");
    }
    public static ElevatorSimulator simulatorStartUp(){

        ElevatorSimulator simulator= new ElevatorSimulator
                (new Building(InputDatiB.nextInt(0, "enter the number of floors of the building"),
                InputDatiB.nextInt(0, "enter the number of underground floors of the building")),
                InputDatiB.nextInt(0, "enter the maximum people load of the elevator",
                InputDatiB.nextInt(0, "enter the starting floor")
                ;
    }
}