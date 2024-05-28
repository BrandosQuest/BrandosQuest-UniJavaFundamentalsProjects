package ArchivioCDpackage;

import mylib.InputDatiB;

import java.util.ArrayList;

/**
 * The class used to represent a CD in the archive
 *
 * @author brando
 */
public class CD {
    /**
     * String representing the artist of the CD
     */
    private String artist;
    /**
     * String representing the title of the CD
     */
    private String title;
    /**
     * ArrayList of Tracks representing the tracks of the CD
     */
    private ArrayList<Track> tracks=new ArrayList<>();

    /**Constructor of the CD
     * @param cds List of already created CDs used to prevent the creation of a cd with the same title
     */
    public CD(ArrayList<CD> cds) {
        this.artist = InputDatiB.nextStringLine("Input the artist:");

        boolean sameTitle = false;
        do {
            this.title = InputDatiB.nextStringLine("Input the title:");
            for (CD cd : cds) {
                if (cd.title.equals(this.title)) {
                    sameTitle = true;
                    System.out.println("title: " + this.title+" is already in used");
                    break;
                }else {
                    sameTitle = false;
                }
            }
        } while (sameTitle);

        System.out.println("Input the tracks(or hit 0 to exit):");
        String t;
        do {
            t = InputDatiB.nextStringLine("Input the track:");
            this.tracks.add(new Track(t));
        } while (!t.equals("0"));
        tracks.removeLast();
    }

    /**Method that returns a random track
     * @return a random track
     */
    public Track getRandomTrack() {
        return tracks.get((int)(Math.random()*tracks.size()));
    }
    /**Method that returns the index of a specified track form the title
     * @param title the title used for the search
     * @return the index of a specified track or -1
     */
    public int getTrackIndex(String title) {
        for (int i = 0; i < tracks.size(); i++) {
            if(tracks.get(i).getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    /**Getter of the artist
     * @return The artist name
     */
    public String getArtist() {
        return artist;
    }
    /**Getter of the title
     * @return The title of the cd
     */
    public String getTitle() {
        return title;
    }
    /**Getter of the tracks
     * @return The list of tracks of the cd
     */
    public ArrayList<Track> getTracks() {
        return tracks;
    }

    /**method toString of the CD object
     * @return a string representing the cd
     */
    @Override
    public String toString() {
        return "CD{" +
                "artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", tracks=" + tracks +
                '}';
    }
}
