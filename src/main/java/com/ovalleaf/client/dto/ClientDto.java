package com.ovalleaf.client.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    @NotEmpty(message = "FirstName is mandatory")
    private String firstName;

    @NotEmpty(message = "LastName is mandatory")
    private String lastName;

    private String mobileNumber;

    @NotEmpty(message = "IdNumber is mandatory")
    private String idNumber;

    private String physicalAddress;

}
