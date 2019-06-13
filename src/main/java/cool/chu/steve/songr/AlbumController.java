package cool.chu.steve.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/allAlbums")
    public String getAllAlbums(Model m) {
        Iterable<Album> albumCollection = albumRepository.findAll();
        m.addAttribute("albums", albumCollection);
        return "allAlbums";
    }

    @GetMapping("/addAlbum")
    public String getAddAlbum() {
        return "albumForm";
    }

    @PostMapping("/addAlbumNow")
    public RedirectView addNewAlbum(@RequestParam String artist,
                                    @RequestParam String title,
                                    @RequestParam int songCount,
                                    @RequestParam int length,
                                    @RequestParam String imageURL) {
        Album newAlbum = new Album(title, artist, songCount, length, imageURL);
        albumRepository.save(newAlbum);
        return new RedirectView("/allAlbums");
    }
}
