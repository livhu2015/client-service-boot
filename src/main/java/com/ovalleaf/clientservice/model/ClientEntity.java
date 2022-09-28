package com.ovalleaf.clientservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "client")
@Builder
@Data
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String lastName;
    @Column
    private String mobileNumber;
    @Column
    private String idNumber;
    @Column
    private String physicalAddress;
}
