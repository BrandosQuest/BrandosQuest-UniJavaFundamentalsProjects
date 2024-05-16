package ArchivioCDpackage;

/**
 * The class used to represent a track in a CD
 *
 * @author brando
 */
public class Track {
    String title;

    public Track(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
