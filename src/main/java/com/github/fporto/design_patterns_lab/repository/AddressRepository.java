package com.github.fporto.design_patterns_lab.repository;

import com.github.fporto.design_patterns_lab.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, Long> {
    Optional<Address> findAddressByZip(String zip);
}
