package ArchivioCDpackage;

import mylib.InputDatiB;
import mylib.MenuB;

import java.util.ArrayList;

/**
 * The class used to represent the CD archive
 *
 * @author brando
 */
public class Archive {

    private final MenuB menuB = new MenuB("CD ARCHIVE", new String[] {"Add a CD to the collection", "Show a CD and it's content",
            "Remove a CD", "See all CD's and their content", "Select a random track from the archive", "Select a random track from an artist",
            "Select a track from the title", "Select a random list of tracks from the archive"});
    private ArrayList<CD> cds = new ArrayList<>();

    public Archive() {

    }
    public void start() {

        int choice;

        do {
            menuB.printMenuPlusQuit();
            choice= InputDatiB.nextInt(0,8, -1);

            if (!(cds.isEmpty() && (choice!=1 && choice!=0))) {
                int cdIndex;
                switch (choice) {
                    case 1:
                        cds.add(new CD(cds));
                        System.out.println(cds.getLast().toString());
                        break;
                    case 2:
                        cdIndex= searchCDFromTitle();
                        if (cdIndex!=-1) {
                            System.out.println(cds.get(cdIndex));
                        }
                        break;
                    case 3:
                        cdIndex= searchCDFromTitle();
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
                        searchTrackFromArtist();
                        break;
                    case 7:
                        searchTrackFromTitle();
                        break;
                    case 8:
                        selectRandomTracks();
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
        } while (choice!=0);
    }

    public ArrayList<CD> getCds() {
        return cds;
    }

    public void setCds(ArrayList<CD> cds) {
        this.cds = cds;
    }

    public int searchCDFromTitle() {
        String title=InputDatiB.nextStringLine("Enter the title: ");
        for (int i = 0; i < cds.size(); i++) {
            if(cds.get(i).getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        System.out.println("CD not found");
        return -1;
    }
    public void searchTrackFromArtist() {
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
    public void searchTrackFromTitle() {
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
    public void selectRandomTracks() {
        int num=InputDatiB.nextInt(1, "Enter the number of tracks to select: ");
        int cdIndex;
        for (int i = 0; i < num; i++) {
            cdIndex=(int)(Math.random()*cds.size());
            cds.get(cdIndex).getRandomTrack();
            System.out.println("- "+cds.get(cdIndex).getRandomTrack()+ " from " + cds.get(cdIndex).getTitle());
        }
    }
}
