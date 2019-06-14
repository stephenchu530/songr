package cool.chu.steve.songr;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String title;
    String artist;
    int songCount;
    int length;
    String imageURL;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    List<Song> songs;

    public Album() {}

    public Album(String title, String artist, int songCount, int length, String imageURL) {
        this.setTitle(title);
        this.setArtist(artist);
        this.setSongCount(songCount);
        this.setLength(length);
        this.setImageURL(imageURL);
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty())
            title = "No Title";
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if (artist.isEmpty())
            artist = "Unknown Artist";
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        if (songCount < 0)
            songCount = 0;
        this.songCount = songCount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length < 0)
            length = 0;
        this.length = length;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        if (imageURL.isEmpty())
            imageURL = "https://cdn.onlinewebfonts.com/svg/img_148071.png";
        this.imageURL = imageURL;
    }

    public List<Song> getSongs() {
        return this.songs;
    }
}
