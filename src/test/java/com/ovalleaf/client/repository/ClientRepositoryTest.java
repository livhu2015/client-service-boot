package com.ovalleaf.client.repository;

import com.ovalleaf.client.model.ClientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest

public class ClientRepositoryTest {
    @Autowired
    ClientRepository clientRepository;

    @Test
    public void should_find_no_clients_if_repository_is_empty() {
        Iterable clients = clientRepository.findAll();

        assertThat(clients).isEmpty();
    }

    @Test
    public void should_save_a_client() {
        ClientEntity expectedClient = ClientEntity.builder().id(1L)
                .firstName("some name")
                .lastName("some lastname")
                .mobileNumber("some number")
                .idNumber("some id number")
                .physicalAddress("some address")
                .build();

        ClientEntity clientEntity = clientRepository.save(expectedClient);
        assertThat(clientEntity).hasFieldOrPropertyWithValue("id", 1L);
        assertThat(clientEntity).hasFieldOrPropertyWithValue("firstName", "some name");
        assertThat(clientEntity).hasFieldOrPropertyWithValue("lastName", "some lastname");
        assertThat(clientEntity).hasFieldOrPropertyWithValue("idNumber", "some id number");
    }

    @Test
    public void should_find_a_client_by_first_name() {
        ClientEntity expectedClient = ClientEntity.builder().id(2L)
                .firstName("some name 1")
                .lastName("some lastname")
                .mobileNumber("some number")
                .idNumber("some id number")
                .physicalAddress("some address")
                .build();

        clientRepository.save(expectedClient);

        ClientEntity foundClientEntity = clientRepository.findByFirstNameOrMobileNumberOrIdNumber(expectedClient.getFirstName(),
                expectedClient.getMobileNumber(), expectedClient.getIdNumber());

        assertThat(foundClientEntity).isEqualTo(expectedClient);
    }
}
