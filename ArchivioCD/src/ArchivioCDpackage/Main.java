package ArchivioCDpackage;

import mylib.InputDatiB;
import mylib.MenuB;

import java.util.ArrayList;

/**
 * The Main class of my project, Archivio CD, containing the runnable main method
 *
 * @author brando
 */
public class Main {
    /**
     * The runnable method of my project
     * @param args the parameters of the main method, where the execution starts
     */
    public static void main(String[] args) {
        final MenuB menuB = new MenuB("CD ARCHIVE", new String[] {"Add a CD to the collection", "Show a CD and it's content",
            "Remove a CD", "See all CD's and their content", "Select a track from a CD", "Select a track from the title"});

        ArrayList<CD> cds = new ArrayList<CD>();

        int choice;

        do {
            menuB.printMenuPlusQuit();
            choice=InputDatiB.nextInt(0,6);

            switch (choice) {
                case 1:
                    cds.add(new CD());
                    System.out.println(cds.getLast().toString());
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 0:

                    break;
                default:

                    break;
            }
        } while (choice!=0);
    }
}