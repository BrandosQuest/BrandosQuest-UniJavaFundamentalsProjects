package ArchivioCDpackage;

import mylib.InputDatiB;

import java.util.ArrayList;

/**
 * The class used to represent a CD in the archive
 *
 * @author brando
 */
public class CD {
    private String artist;
    private String title;
    private ArrayList<Track> tracks=new ArrayList<>();

    public CD() {
        this.artist = InputDatiB.nextString("Input the artist:");
        this.title = InputDatiB.nextString("Input the title:");
        System.out.println("Input the tracks(or hit 0 to exit):");

        String t;
        do {
            t = InputDatiB.nextString("Input the track:");
            this.tracks.add(new Track(t));
        } while (!t.equals("0"));
        tracks.removeLast();
    }

    @Override
    public String toString() {
        return "CD{" +
                "artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", tracks=" + tracks +
                '}';
    }
}
