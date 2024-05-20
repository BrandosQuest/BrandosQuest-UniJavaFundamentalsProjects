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
            choice=InputDatiB.nextInt(0,6, -1);

            switch (choice) {
                case 1:
                    cds.add(new CD(cds));
                    System.out.println(cds.getLast().toString());
                    break;
                case 2:
                    int cdIndex=searchCD(cds);
                    if (cdIndex!=-1) {
                        System.out.println(cds.get(cdIndex));
                    }
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
                    System.out.println("Not an option, try again");
                    break;
            }
        } while (choice!=0);
    }
    public static int searchCD(ArrayList<CD> cds) {
        String title=InputDatiB.nextStringLine("Enter the title: ");
        for (int i = 0; i < cds.size(); i++) {
            if(cds.get(i).getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        System.out.println("CD not found");
        return -1;
    }
}