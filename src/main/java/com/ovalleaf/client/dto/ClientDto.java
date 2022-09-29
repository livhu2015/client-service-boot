package com.ovalleaf.client.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    @NotEmpty(message = "FirstName is mandatory")
    private String firstName;

    @NotEmpty(message = "LastName is mandatory")
    private String lastName;

    private String mobileNumber;

    @Pattern(regexp = "\\d{10}[0|1]\\d{2}")
    @NotEmpty(message = "IdNumber is mandatory")
    private String idNumber;

    private String physicalAddress;

}
