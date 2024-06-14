package ElevatorPackage;

import mylib.InputDatiB;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimulatorFileUtils {
    public static ElevatorSimulator textFileStartUp(){
        System.out.print("LOADING FROM TEXT FILE ");
        File inputFile = new File("saves/elevatorSimulatorInitialState.txt");
        ElevatorSimulator simulator = null;
        System.out.println(inputFile.getPath());
        LinkedList<String> linesRead= new LinkedList<>();
        try {
            Scanner scanner = new Scanner(
                    new FileReader(inputFile));
            while (scanner.hasNext()) {
                linesRead.add(scanner.nextLine());
            }
        }catch (IOException e){
            System.out.println("Error in reading the file, going into manual mode\n"+e.getMessage());
            return null;
        }

        ListIterator<String> iterator = linesRead.listIterator();
        while(iterator.hasNext()){
            String line = iterator.next();
            if(line.startsWith("!") || line.isEmpty() || line.startsWith(" ")){
                iterator.remove();
            }else {
                line= line.replaceAll("_","");
                line= line.replaceAll(",","");
                //System.out.println(line);
                iterator.set(line);
            }
        }
        ListIterator<String> iterate = linesRead.listIterator();
        int sectionNumber =0;
        int floors = 0;
        int undergroundFloors = 0;
        int elevatorPosition = 0;
        int maxPeopleLoad;
        while(iterate.hasNext()){
            //System.out.println(sectionNumber);
            String line = iterate.next();
            if(line.startsWith(">")){
                sectionNumber++;
                //iterator.remove();
            }else {
                switch (sectionNumber){
                    case 1:
                        floors=Integer.parseInt(line);
                        break;
                    case 2:
                        undergroundFloors=Integer.parseInt(line);
                        break;
                    case 3:
                        elevatorPosition=Integer.parseInt(line);
                        break;
                    case 4:
                        maxPeopleLoad=Integer.parseInt(line);
                        simulator= new ElevatorSimulator(new Building(floors, undergroundFloors), elevatorPosition, maxPeopleLoad);
                        break;
                    case 5:
                        while (iterate.hasNext()){
                            if(line.startsWith(">")){
                                break;
                            }
                            assert simulator != null;
                            int originFloor = Integer.parseInt(line.split(" ")[0]);
                            int destinationFloor = Integer.parseInt(line.split(" ")[1]);
                            if (originFloor != destinationFloor) {
                                simulator.elevatorCall(originFloor, destinationFloor);
                                //System.out.println(originFloor+" "+destinationFloor);
                            } else {
                                System.out.println("Call skipped, waiting floor is the same as the destination floor, fix the text file");
                            }
                            line = iterate.next();
                        }
                        iterate.previous();
                        break;
                    case 6:
                        iterate.previous();
                        while (iterate.hasNext()){
                            line = iterate.next();
                            if(line.startsWith(">")){
                                break;
                            }
                            assert simulator != null;
                            int destinationFloor = Integer.parseInt(line);
                            if (elevatorPosition != destinationFloor) {
                                simulator.elevatorCall(elevatorPosition, destinationFloor);
                                //System.out.println(elevatorPosition+" "+destinationFloor);
                            } else {
                                System.out.println("Call skipped, elevator starting floor is the same as the destination floor, fix the text file");
                            }

                        }
                        break;
                    default:
                        System.out.println("Something is wrong in the text file, to many sections");
                        break;
                }
            }
        }
        return simulator;
    }
    public static ElevatorSimulator savedStartUp(){
        System.out.println("LOADING FROM PAST SAVED SIMULATION");
        String name = InputDatiB.nextStringLine("enter the name of the saved simulation or D to use the last default save (\"save+numberSave\")");
        ElevatorSimulator simulator;
        File inputFile;

        if(name.equalsIgnoreCase("d")){
            File f = new File("saves/objectSaves");
            inputFile = new File("saves/objectSaves/save"+determineMaxIdOfSaves(f)+".txt");
        }else {
            inputFile = new File("saves/objectSaves/"+name+".txt");
        }

        try {
            ObjectInputStream objectOutputStream = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(inputFile)));
            simulator = (ElevatorSimulator) objectOutputStream.readObject();
            objectOutputStream.close();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error in reading the file, going into manual mode\n"+e.getMessage());
            return null;
        }

        return simulator;
    }
    public static void saveSimulation(ElevatorSimulator simulator){
        System.out.println("SAVING CURRENT SIMULATION");
        String name = InputDatiB.nextStringLine("enter a name for the save or D to use the default \"save+numberSave\"");

        File savingFile;
        if(name.equalsIgnoreCase("d")){
            File f = new File("saves/objectSaves");
            savingFile = new File("saves/objectSaves/save"+(determineMaxIdOfSaves(f)+1)+".txt");
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
    private static int determineMaxIdOfSaves(File f){
        String[] s = f.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // Define the regex pattern to match a string that ends with a digit
                String regex = "\\d\\.txt$";
                // Compile the pattern
                Pattern pattern = Pattern.compile(regex);
                // Create a matcher for the input string
                Matcher matcher = pattern.matcher(name);
                // Check if the pattern matches the entire input string
                return name.startsWith("save") && matcher.find();
                //return dir.getName().startsWith("save") && dir.getName().endsWith("\\d");
            }
        });
        int max=0;
        for (int i = 0; i < Objects.requireNonNull(s).length; i++) {
            s[i]=s[i].substring(4);
            s[i]=s[i].split(".txt")[0];
            if(Integer.parseInt(s[i])>max){
                max=Integer.parseInt(s[i]);
            }
        }
        return max;
    }
}
