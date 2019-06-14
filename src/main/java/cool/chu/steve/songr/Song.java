package cool.chu.steve.songr;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String title;
    private int length;
    private int trackNumber;
    @ManyToOne
    private Album album;

    public Song(long id, String title, int length, int trackNumber, Album album) {
        this.setTitle(title);
        this.setLength(length);
        this.setTrackNumber(trackNumber);
        this.setAlbum(album);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty())
            title = "No Title";
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length < 0)
            length = 0;
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        if (trackNumber < 0)
            trackNumber = 0;
        this.trackNumber = trackNumber;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
