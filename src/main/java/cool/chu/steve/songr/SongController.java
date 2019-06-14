package cool.chu.steve.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/allSongs")
    public String getAllSongs(Model m) {
        m.addAttribute("songs", songRepository.findAll());
        return "allSongs";
    }

    @PostMapping("/addSong")
    public String getAddSong(@RequestParam long id, Model m) {
        Album album = albumRepository.findById(id).get();
        m.addAttribute("album", album);
        return "songForm";
    }

    @PostMapping("/addSongNow")
    public RedirectView addNewSong(@RequestParam String title,
                                   @RequestParam int length,
                                   @RequestParam int trackNumber,
                                   @RequestParam long albumId) {
        Album album = albumRepository.findById(albumId).get();
        Song newSong = new Song(title, length, trackNumber, album);
        album.setLength(album.getLength() + length);
        album.setSongCount(album.getSongCount() + 1);
        albumRepository.save(album);
        songRepository.save(newSong);
        return new RedirectView("/allAlbums");
    }
}
