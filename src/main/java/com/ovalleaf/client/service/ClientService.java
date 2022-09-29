package com.ovalleaf.client.service;

import com.ovalleaf.client.dto.ClientDto;
import com.ovalleaf.client.model.ClientEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    ClientEntity createClient(ClientDto createClient) throws Exception;
    ClientEntity searchClient(String firstName, String mobileNumber, String idNumber) throws Exception;
    ClientEntity updateClient(String idNumber, ClientDto updateClient) throws Exception;
}
