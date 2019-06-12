package cool.chu.steve.songr;

// The following pattern was gotten from:
// https://spring.io/guides/gs/testing-web/

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SongrControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        this.mockMvc
                .perform(get("/hello"))
                .andExpect(content()
                        .string(containsString("Hello, World!")));
    }

    @Test
    public void testCapitalize() throws Exception {
        this.mockMvc
                .perform(get("/capitalize/Java is cool"))
                .andExpect(content()
                        .string(containsString("JAVA IS COOL")));
    }

    @Test
    public void testReverse() throws Exception {
        this.mockMvc
                .perform(get("/reverse")
                        .param("sentence", "Java is cool"))
                .andExpect(content()
                        .string(containsString("cool is Java")));
    }
}