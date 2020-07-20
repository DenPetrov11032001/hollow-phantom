package hollow.phantom.junit;

import hollow.phantom.controller.MessageController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-user-before.sql", "/messages-list-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/messages-list-after.sql", "/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class MessageControllerTest {
    @Autowired
    private MessageController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void mainPageTest() throws Exception {
        this.mockMvc.perform(get("/message"))
                .andDo(print())
                .andExpect(xpath("//*[@id='message']/div").nodeCount(2));
    }

    @Test
    public void addMessage() throws Exception {
        this.mockMvc.perform(post("/message")
                .param("text", "test"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//*[@id='message']/div").nodeCount(3));
    }

    @Test
    public void updateMessage() throws Exception {
        this.mockMvc.perform(put("/message/3").param("text", "test update"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//*[@id='message']/div").nodeCount(3));
    }

    @Test
    public void deleteMessage() throws Exception {
        this.mockMvc.perform(delete("/message/3"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//*[@id='message']/div").nodeCount(2));
    }
}
