package at.hochschule.umzug;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UmzugControllerTest {

//    @InjectMocks
//    private UmzugController controller;

    @Autowired
    private MockMvc mockMvc;

/*    @Test
    void createRequest() {
        MovingRequest request = new MovingRequest();
        request.setName("Max Mustermann");
        request.setTime("10:00 01.04.2025");
        request.setOrigin("Musterstrasse 1");
        request.setDestination("Beispielgasse 10");
        request.setTime("Tisch");
        request.setAmount("3");

        String retMessage = "Anfrage erfolgreich gespeichert";
        when()
    }*/

    @Test
    public void shouldSaveValidRequest() throws Exception {
        String requestBody = """
            {
                "name": "John Doe",
                "time": "10:00",
                "origin": "Berlin",
                "destination": "Hamburg",
                "item": "Table",
                "amount": "2"
            }
        """;

        mockMvc.perform(post("/api/umzug")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Request saved successfully"));
    }

    @Test
    public void shouldReturn400IfFieldsAreMissing() throws Exception {
        String requestBody = """
        {
            "name": "John Doe"
        }
    """;

        mockMvc.perform(post("/api/umzug")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("All fields are required"));
    }

}