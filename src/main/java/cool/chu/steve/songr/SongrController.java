package cool.chu.steve.songr;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SongrController {
    @GetMapping("/hello")
    public String getHelloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/capitalize/{word}")
    public String capitalize(@PathVariable String word) {
        return word.toUpperCase();
    }

    @GetMapping("/reverse")
    public String reverse(@RequestParam String sentence) {

        // Reverse words in a string gotten from:
        // https://howtodoinjava.com/java/string/reverse-words-in-string/
        String[] words = sentence.split(" ");
        String reversed = "";

        for (String word : words)
        {
            reversed = word + " " + reversed;
        }
        return reversed.toString().trim();
    }
}
