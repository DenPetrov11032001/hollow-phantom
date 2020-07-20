package hollow.phantom.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class CommentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addComment() throws Exception {
        this.mockMvc.perform(post("/comment")
                .param("text", "test")
                .param("message_id", "2"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//*[@id='comment']/div").nodeCount(1));
    }

    @Test
    public void updateComment() throws Exception {
        this.mockMvc.perform(put("/comment/1").param("text", "test update"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//*[@id='comment']/div").nodeCount(1));
    }

    @Test
    public void deleteComment() throws Exception {
        this.mockMvc.perform(delete("/comment/1"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//*[@id='comment']/div").nodeCount(0));
    }
}
