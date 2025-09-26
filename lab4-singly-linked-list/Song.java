
public class Song {
    private String title;
    private String artist;

    // Constructor
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for artist
    public String getArtist() {
        return artist;
    }

    // using toString to print whole text
    @Override
    public String toString() {
        return title + " by " + artist;
    }
}
