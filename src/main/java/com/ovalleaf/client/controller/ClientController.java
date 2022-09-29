package com.ovalleaf.client.controller;

import com.ovalleaf.client.dto.ClientDto;
import com.ovalleaf.client.model.ClientEntity;
import com.ovalleaf.client.service.ClientService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
public class ClientController {
    @Qualifier("clientService")
    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    ResponseEntity<ClientEntity> create(@Valid @RequestBody ClientDto createClient) throws Exception{
        ClientEntity response = clientService.createClient(createClient);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    ResponseEntity<ClientEntity> update(@RequestParam String idNumber, @RequestBody ClientDto updateClient) throws Exception {
        ClientEntity response = clientService.updateClient(idNumber, updateClient);
        return ResponseEntity.ok(response);
    }

    /**
     * You should be able to search for a client using any one of the following fields FirstName or ID  Number or Phone Number
     * @param firstName
     * @return
     */
    @GetMapping("/search")
    ResponseEntity<ClientEntity> search(@RequestParam String firstName,
                                        @RequestParam String mobileNumber, @RequestParam String idNumber) throws Exception {
        ClientEntity response = clientService.searchClient(firstName, mobileNumber, idNumber);
        return ResponseEntity.ok(response);
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
