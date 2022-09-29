package com.ovalleaf.client.controller;

import com.ovalleaf.client.dto.ClientDto;
import com.ovalleaf.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * REST API that allows for creating, updating and searching for a client.
 */
@RestController
public class ClientController {
    @Qualifier("clientService")
    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    ResponseEntity<String> create(@Valid @RequestBody ClientDto createClient) {
        String response = clientService.createClient(createClient);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update")
    ResponseEntity<String> update(@RequestBody String updateClient){
        return null;
    }

    @PostMapping("/search")
    ResponseEntity<String> search(@RequestBody String searchClient){
        return null;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
