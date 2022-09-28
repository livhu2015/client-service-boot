package com.ovalleaf.clientservice.dto;

import lombok.*;

@Data
public class CreateClientDto {
    private String lastName;
    private String mobileNumber;
    private String idNumber;
    private String physicalAddress;
}
