package com.ovalleaf.client.service;

import com.ovalleaf.client.dto.ClientDto;
import com.ovalleaf.client.model.ClientEntity;
import com.ovalleaf.client.repository.ClientRepository;
import com.ovalleaf.client.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
public class ClientServiceImplTest {
    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    void should_successfully_create_a_client() {
        //Given
        ClientDto client = ClientDto.builder()
                .firstName("some name")
                .lastName("some lastname")
                .mobileNumber("some number")
                .idNumber("some id number")
                .physicalAddress("some address")
                .build();

        ClientEntity expectedClient = ClientEntity.builder().id(1L)
                .firstName("some name")
                .lastName("some lastname")
                .mobileNumber("some number")
                .idNumber("some id number")
                .physicalAddress("some address")
                .build();

        //When
        when(clientRepository.save(any(ClientEntity.class))).thenReturn(expectedClient);
        ClientEntity response = clientService.createClient(client);

        //Then
        verify(clientRepository).save(any(ClientEntity.class));
        assertEquals(response.getFirstName(), client.getFirstName());
        assertEquals(response.getPhysicalAddress(), client.getPhysicalAddress());
        assertEquals(response.getIdNumber(), client.getIdNumber());
    }

    @Test
    void should_search_for_a_client_successfully() throws Exception {
        //Given
        String firstName = "some name";
        String mobileNumber = "some number";
        String idNumber = "some id number";

        ClientEntity expectedClient = ClientEntity.builder().id(1L)
                .firstName("some name")
                .lastName("some lastname")
                .mobileNumber("some number")
                .idNumber("some id number")
                .physicalAddress("some address")
                .build();

        //When
        when(clientRepository.findByFirstNameOrMobileNumberOrIdNumber(
                any(String.class), any(String.class), any(String.class))).thenReturn(expectedClient);

        ClientEntity response = clientService.searchClient(firstName, mobileNumber, idNumber);

        //Then
        verify(clientRepository).findByFirstNameOrMobileNumberOrIdNumber(any(String.class),
                any(String.class), any(String.class));

        assertEquals(response.getFirstName(), firstName);
        assertEquals(response.getMobileNumber(), mobileNumber);
        assertEquals(response.getIdNumber(), idNumber);
    }

    @Test
    void should_search_with_only_firstname_client_and_return_success_response() throws Exception {
        //Given
        String firstName = "some name";
        String mobileNumber = "";
        String idNumber = "";

        ClientEntity expectedClient = ClientEntity.builder().id(1L)
                .firstName("some name")
                .lastName("some lastname")
                .mobileNumber("some number")
                .idNumber("some id number")
                .physicalAddress("some address")
                .build();

        //When
        when(clientRepository.findByFirstNameOrMobileNumberOrIdNumber(
                any(String.class), any(String.class), any(String.class))).thenReturn(expectedClient);

        ClientEntity response = clientService.searchClient(firstName, mobileNumber, idNumber);

        //Then
        verify(clientRepository).findByFirstNameOrMobileNumberOrIdNumber(any(String.class),
                any(String.class), any(String.class));

        assertEquals(response.getFirstName(), firstName);
        assertNotEquals(response.getMobileNumber(), mobileNumber);
        assertNotEquals(response.getIdNumber(), idNumber);
    }

    @Test
    void should_search_with_only_mobile_number_client_and_return_success_response() throws Exception {
        //Given
        String firstName = "";
        String mobileNumber = "some number";
        String idNumber = "";

        ClientEntity expectedClient = ClientEntity.builder().id(1L)
                .firstName("some name")
                .lastName("some lastname")
                .mobileNumber("some number")
                .idNumber("some id number")
                .physicalAddress("some address")
                .build();

        //When
        when(clientRepository.findByFirstNameOrMobileNumberOrIdNumber(
                any(String.class), any(String.class), any(String.class))).thenReturn(expectedClient);

        ClientEntity response = clientService.searchClient(firstName, mobileNumber, idNumber);

        //Then
        verify(clientRepository).findByFirstNameOrMobileNumberOrIdNumber(any(String.class),
                any(String.class), any(String.class));

        assertNotEquals(response.getFirstName(), firstName);
        assertEquals(response.getMobileNumber(), mobileNumber);
        assertNotEquals(response.getIdNumber(), idNumber);
    }

    @Test
    void should_search_with_only_idnumber_client_and_return_success_response() throws Exception {
        //Given
        String firstName = "";
        String mobileNumber = "";
        String idNumber = "some id number";

        ClientEntity expectedClient = ClientEntity.builder().id(1L)
                .firstName("some name")
                .lastName("some lastname")
                .mobileNumber("some number")
                .idNumber("some id number")
                .physicalAddress("some address")
                .build();

        //When
        when(clientRepository.findByFirstNameOrMobileNumberOrIdNumber(
                any(String.class), any(String.class), any(String.class))).thenReturn(expectedClient);

        ClientEntity response = clientService.searchClient(firstName, mobileNumber, idNumber);

        //Then
        verify(clientRepository).findByFirstNameOrMobileNumberOrIdNumber(any(String.class),
                any(String.class), any(String.class));

        assertNotEquals(response.getFirstName(), firstName);
        assertNotEquals(response.getMobileNumber(), mobileNumber);
        assertEquals(response.getIdNumber(), idNumber);
    }

    @Test
    void should_successfully_update_client() throws Exception {
        //Given
        String idNumber = "some id number";

        ClientDto updateClient = ClientDto.builder()
                .firstName("some name 1")
                .lastName("some lastname")
                .mobileNumber("some number")
                .idNumber("some id number")
                .physicalAddress("some address")
                .build();

        ClientEntity expectedClient = ClientEntity.builder().id(1L)
                .firstName("some name 1")
                .lastName("some lastname")
                .mobileNumber("some number")
                .idNumber("some id number")
                .physicalAddress("some address")
                .build();

        //When
        when(clientRepository.findByIdNumber(any(String.class))).thenReturn(expectedClient);

        when(clientRepository.save(any(ClientEntity.class))).thenReturn(expectedClient);
        ClientEntity response = clientService.updateClient(idNumber, updateClient);

        //Then
        verify(clientRepository).findByIdNumber(any(String.class));
        verify(clientRepository).save(any(ClientEntity.class));
        assertEquals(response.getFirstName(), updateClient.getFirstName());
        assertEquals(response.getMobileNumber(), updateClient.getMobileNumber());
        assertEquals(response.getIdNumber(), updateClient.getIdNumber());
    }
}
