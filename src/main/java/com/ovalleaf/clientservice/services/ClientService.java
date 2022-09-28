package com.ovalleaf.clientservice.services;

import com.ovalleaf.clientservice.dto.CreateClientDto;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    String createClient(CreateClientDto createClient);
}
