package com.ovalleaf.client.service.impl;

import com.ovalleaf.client.dto.ClientDto;
import com.ovalleaf.client.model.ClientEntity;
import com.ovalleaf.client.repository.ClientRepository;
import com.ovalleaf.client.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    /**
     * @param createClient
     * @return
     */
    @Override
    public ClientEntity createClient(ClientDto createClient) {
        ClientEntity clientEntity = ClientEntity.builder()
                .firstName(createClient.getFirstName())
                .lastName(createClient.getLastName())
                .idNumber(createClient.getIdNumber())
                .mobileNumber(createClient.getMobileNumber())
                .physicalAddress(createClient.getPhysicalAddress())
                .build();

        ClientEntity createdClient = clientRepository.save(clientEntity);
        log.info("Client created |-> " + createdClient);

        return createdClient;
    }

    /**
     * @param firstName
     * @return
     */
    @Override
    public ClientEntity searchClient(String firstName, String mobileNumber, String idNumber) throws Exception {
        ClientEntity clientResponse = clientRepository.findByFirstNameOrMobileNumberOrIdNumber(firstName, mobileNumber, idNumber);
        if (clientResponse == null) {
            throw new Exception("Client not Found");
        }
        log.info("Found client: "+ clientResponse.toString());
        return clientResponse;
    }

    /**
     * @param updateClient
     * @return
     */
    @Override
    public ClientEntity updateClient(String idNumber, ClientDto updateClient) throws Exception {
        ClientEntity client = clientRepository.findByIdNumber(idNumber);

        log.info("Found client: " + client.toString());

        ClientEntity updatedClient = ClientEntity.builder()
                .id(client.getId())
                .firstName(updateClient.getFirstName())
                .lastName(updateClient.getLastName())
                .idNumber(updateClient.getIdNumber())
                .mobileNumber(updateClient.getMobileNumber())
                .physicalAddress(updateClient.getPhysicalAddress())
                .build();

        ClientEntity UpdateResponse = clientRepository.save(updatedClient);
        return UpdateResponse;

    }
}
