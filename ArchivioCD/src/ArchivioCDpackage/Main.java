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
        Archive archive = new Archive();
        archive.start();
        /*final MenuB menuB = new MenuB("CD ARCHIVE", new String[] {"Add a CD to the collection", "Show a CD and it's content",
            "Remove a CD", "See all CD's and their content", "Select a random track from the archive", "Select a random track from an artist",
            "Select a track from the title", "Select a random list of tracks from the archive"});

        ArrayList<CD> cds = new ArrayList<CD>();

        int choice;

        do {
            menuB.printMenuPlusQuit();
            choice=InputDatiB.nextInt(0,8, -1);

            if (!(cds.isEmpty() && (choice!=1 && choice!=0))) {
                int cdIndex;
                switch (choice) {
                    case 1:
                        cds.add(new CD(cds));
                        System.out.println(cds.getLast().toString());
                        break;
                    case 2:
                        cdIndex= searchCDFromTitle(cds);
                        if (cdIndex!=-1) {
                            System.out.println(cds.get(cdIndex));
                        }
                        break;
                    case 3:
                        cdIndex= searchCDFromTitle(cds);
                        if (cdIndex!=-1) {
                            System.out.println(cds.get(cdIndex).getTitle()+" CD removed");
                            cds.remove(cdIndex);
                        }
                        break;
                    case 4:
                        for (CD cd : cds) {
                            System.out.println(cd);
                        }
                        break;
                    case 5:
                        cdIndex=(int)(Math.random()*cds.size());
                        System.out.println(cds.get(cdIndex).getRandomTrack()+" from "+cds.get(cdIndex).getTitle());
                        break;
                    case 6:
                        searchTrackFromArtist(cds);
                        break;
                    case 7:
                        searchTrackFromTitle(cds);
                        break;
                    case 8:
                        selectRandomTracks(cds);
                        break;
                    case 0:

                        break;
                    default:
                        System.out.println("Not an option, try again");
                        break;
                }
            } else {
                System.out.println("Add a CD to the archive first");
            }
        } while (choice!=0);*/
    }
    /*public static int searchCDFromTitle(ArrayList<CD> cds) {
        String title=InputDatiB.nextStringLine("Enter the title: ");
        for (int i = 0; i < cds.size(); i++) {
            if(cds.get(i).getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        System.out.println("CD not found");
        return -1;
    }
    public static void searchTrackFromArtist(ArrayList<CD> cds) {
        String artist=InputDatiB.nextStringLine("Enter the artist's name: ");
        String title=InputDatiB.nextStringLine("Enter the track's name: ");
        int trackIndex;
        boolean found=false;
        for (CD cd : cds) {
            if (cd.getArtist().equalsIgnoreCase(artist)) {
                trackIndex = cd.getTrackIndex(title);
                if (trackIndex != -1) {
                    System.out.println(cd.getTracks().get(trackIndex) + " from " + cd.getTitle() + " found");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Track not found, no match for artist or track");
        }
    }
    public static void searchTrackFromTitle(ArrayList<CD> cds) {
        String title=InputDatiB.nextStringLine("Enter the track's name: ");
        int trackIndex;
        boolean found=false;
        for (CD cd : cds) {
            trackIndex = cd.getTrackIndex(title);
            if (trackIndex != -1) {
                System.out.println(cd.getTracks().get(trackIndex) + " from " + cd.getTitle() + " found");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Track not found, no match for track name");
        }
    }
    public static void selectRandomTracks(ArrayList<CD> cds) {
        int num=InputDatiB.nextInt(1, "Enter the number of tracks to select: ");
        int cdIndex=0;
        for (int i = 0; i < num; i++) {
            cdIndex=(int)(Math.random()*cds.size());
            cds.get(cdIndex).getRandomTrack();
            System.out.println("- "+cds.get(cdIndex).getRandomTrack()+ " from " + cds.get(cdIndex).getTitle());
        }
    }*/
}