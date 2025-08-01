package com.ecommerce.project.repository;

import com.ecommerce.project.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
    @Query("SELECT a FROM Address a WHERE a.addressId =?1")
    Optional<Address> findByAddressId(Long addressId);
}


