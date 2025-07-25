package dev.cacassiano.prontuario_api.users;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import dev.cacassiano.prontuario_api.domain.users.UserController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test user registration - Create successful user")
    public void testRegisterUserCase1() throws Exception {
        this.mockMvc.perform(
                post("/api/v1/users/register")
                        .contentType("application/json")
                        .content("{\"username\":\"testuser\", \"password\":\"password123\", \"email\":\"testuser@testemail.com\"}")
        ).andDo(print())
            .andExpect(status().isCreated())
            .andExpect(content().string("User registered successfully"));
    }
}

