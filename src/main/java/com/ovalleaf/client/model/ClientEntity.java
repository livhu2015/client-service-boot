package com.ovalleaf.client.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Data
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "FirstName may not be null")
    private String firstName;

    @NotNull(message = "LastName may not be null")
    private String lastName;

    private String mobileNumber;

    @NotNull(message = "IdNumber is mandatory")
    private String idNumber;

    private String physicalAddress;
}
