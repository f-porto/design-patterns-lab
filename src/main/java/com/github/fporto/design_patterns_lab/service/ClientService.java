package com.github.fporto.design_patterns_lab.service;

import com.github.fporto.design_patterns_lab.model.Client;

import java.util.Optional;

public interface ClientService {
    Iterable<Client> findAll();
    Optional<Client> findById(Long id);
    void save(Client client);
    void update(Long id, Client client);
    void delete(Long id);
}
