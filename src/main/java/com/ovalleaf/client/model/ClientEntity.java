package com.ovalleaf.client.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull(message = "FirstName may not be null")
    private String firstName;

    @Column
    @NotNull(message = "LastName may not be null")
    private String lastName;

    @Column(unique=true)
    private String mobileNumber;

    @Column(unique=true)
    @NotNull(message = "IdNumber is mandatory")
    private String idNumber;

    private String physicalAddress;
}
