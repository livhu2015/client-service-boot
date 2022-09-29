package com.ovalleaf.client.service;

import com.ovalleaf.client.dto.ClientDto;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    String createClient(ClientDto createClient);
}
