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
    public String createClient(ClientDto createClient) {
        ClientEntity clientEntity = ClientEntity.builder()
                .firstName(createClient.getFirstName())
                .lastName(createClient.getLastName())
                .idNumber(createClient.getIdNumber())
                .mobileNumber(createClient.getMobileNumber())
                .physicalAddress(createClient.getPhysicalAddress())
                .build();

        ClientEntity s = clientRepository.save(clientEntity);
        log.info("Client created |-> " + s);

        return "client created: " + s;
    }
}
