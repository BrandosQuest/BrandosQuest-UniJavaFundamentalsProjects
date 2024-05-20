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

    public Track getRandomTrack() {
        return tracks.get((int)(Math.random()*tracks.size()));
    }
    public int getTrack (String title) {
        for (int i = 0; i < tracks.size(); i++) {
            if(tracks.get(i).getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        System.out.println("Track not found");
        return -1;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
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
