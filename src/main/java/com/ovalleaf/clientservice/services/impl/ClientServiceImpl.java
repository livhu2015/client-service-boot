package com.ovalleaf.clientservice.services.impl;

import com.ovalleaf.clientservice.dto.CreateClientDto;
import com.ovalleaf.clientservice.model.ClientEntity;
import com.ovalleaf.clientservice.repository.ClientRepository;
import com.ovalleaf.clientservice.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    /**
     * @param createClient
     * @return
     */
    @Override
    public String createClient(CreateClientDto createClient) {
        ClientEntity clientEntity = ClientEntity.builder().lastName(createClient.getLastName()).idNumber(createClient.getIdNumber())
                .mobileNumber(createClient.getMobileNumber()).physicalAddress(createClient.getPhysicalAddress()).build();

       ClientEntity s = clientRepository.save(clientEntity);
        log.info("Client created |-> " + s);

        return "client created: " + s;
    }
}
