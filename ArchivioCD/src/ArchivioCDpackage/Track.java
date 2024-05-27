package ArchivioCDpackage;

/**
 * The class used to represent a track in a CD
 *
 * @author brando
 */
public class Track {
    /**
     * Title of the track
     */
    String title;

    /**Constructor of the track
     * @param title Title of the track
     */
    public Track(String title) {
        this.title = title;
    }

    /**Getter of the Title attribute
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**ToString of the Track
     * @return The title
     */
    @Override
    public String toString() {
        return title;
    }
}
