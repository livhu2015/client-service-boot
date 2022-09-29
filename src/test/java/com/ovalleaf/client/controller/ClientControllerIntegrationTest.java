package com.ovalleaf.client.controller;

import com.ovalleaf.client.service.ClientService;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.nio.charset.Charset;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
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
    public void whenClientControllerInjected_thenNotNull() throws Exception {
        assertThat(clientController).isNotNull();
    }

    @Test
    public void whenPostRequestToCreateClientWithMandatoryFields_thenCorrectResponse() throws Exception {

//        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        String client = "{" +
                "\"firstName\": \"bob\"," +
                "\"lastName\": \"bob\"," +
                "\"mobileNumber\": \"bob\"," +
                "\"idNumber\": \"bob\", " +
                "\"physicalAddress\": \"bob\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/create")
                        .content(client)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8));
    }

    @Test
    public void whenPostRequestToCreateClientWithoutMandatoryFields_thenWrongResponse() throws Exception {
        String client = "{" +
                "\"firstName\": \"\"," +
                "\"lastName\": \"bob\"," +
                "\"mobileNumber\": \"bob\"," +
                "\"idNumber\": \"\", " +
                "\"physicalAddress\": \"bob\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/create")
                        .content(client)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Is.is("Name is mandatory")))
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }


}
