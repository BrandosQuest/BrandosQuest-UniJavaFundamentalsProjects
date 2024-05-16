package ArchivioCDpackage;

import mylib.InputDatiB;
import mylib.MenuB;

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

        int choice;

        do {
            menuB.printMenuPlusQuit();
            choice=InputDatiB.nextInt(0,6);
        } while (choice!=0);
    }
}