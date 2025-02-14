package com.github.fporto.design_patterns_lab.repository;

import com.github.fporto.design_patterns_lab.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
