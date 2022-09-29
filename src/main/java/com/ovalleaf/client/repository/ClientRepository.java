package com.ovalleaf.client.repository;

import com.ovalleaf.client.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByFirstNameOrMobileNumberOrIdNumber(String firstName, String mobileNumber, String idNumber);

    ClientEntity findByIdNumber(String idNumber);
}
