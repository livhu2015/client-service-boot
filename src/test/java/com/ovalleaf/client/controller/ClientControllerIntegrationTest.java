package com.ovalleaf.client.controller;

import com.ovalleaf.client.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest
@AutoConfigureMockMvc
public class ClientControllerIntegrationTest {
    @Autowired
    ClientController clientController;

    @MockBean
    private ClientService clientService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void when_client_controller_is_injected_then_result_NotNull() throws Exception {
        assertThat(clientController).isNotNull();
    }

    @Test
    public void when_post_a_request_to_create_a_client_with_mandatory_fields_then_results_a_correct_response() throws Exception {
        String client = "{" +
                "\"firstName\": \"Blob\"," +
                "\"lastName\": \"Maake\"," +
                "\"mobileNumber\": \"082432438\"," +
                "\"idNumber\": \"9105075983081\", " +
                "\"physicalAddress\": \"17 horn street, Sandton, 2001 \"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/create")
                        .content(client)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void when_post_request_to_create_a_client_without_mandatory_fields_then_result_wrong_response() throws Exception {
        String client = "{" +
                "\"firstName\": \"\"," +
                "\"lastName\": \"bob\"," +
                "\"mobileNumber\": \"bob\"," +
                "\"idNumber\": \"\", " +
                "\"physicalAddress\": \"bob\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/create")
                        .content(client)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    public void when_post_request_to_create_a_client_with_an_invalid_SA_ID_number_then_result_correct_response() throws Exception {
        String client = "{" +
                "\"firstName\": \"Blob\"," +
                "\"lastName\": \"Maake\"," +
                "\"mobileNumber\": \"082432438\"," +
                "\"idNumber\": \"9105075983\", " +
                "\"physicalAddress\": \"17 horn street, Sandton, 2001 \"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/create")
                        .content(client)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void when_post_request_to_create_a_client_with_an_invalid_then_correct_response() throws Exception {
        String client = "{" +
                "\"firstName\": \"Blob\"," +
                "\"lastName\": \"Maake\"," +
                "\"mobileNumber\": \"082432438\"," +
                "\"idNumber\": \"9105075983\", " +
                "\"physicalAddress\": \"17 horn street, Sandton, 2001 \"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/create")
                        .content(client)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

}
