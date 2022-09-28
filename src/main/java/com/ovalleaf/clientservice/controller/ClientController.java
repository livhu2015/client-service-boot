package com.ovalleaf.clientservice.controller;

import com.ovalleaf.clientservice.dto.CreateClientDto;
import com.ovalleaf.clientservice.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST API that allows for creating, updating and searching for a client.
 */
@RestController("client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("create")
    ResponseEntity<String> create(@RequestBody CreateClientDto createClient) {
        String response = clientService.createClient(createClient);
        return ResponseEntity.ok(response);
    }

    @PostMapping("update")
    ResponseEntity<String> update(@RequestBody String updateClient){
        return null;
    }

    @PostMapping("search")
    ResponseEntity<String> search(@RequestBody String searchClient){
        return null;
    }
}
