package com.github.fporto.design_patterns_lab.service;

import com.github.fporto.design_patterns_lab.model.Client;
import com.github.fporto.design_patterns_lab.repository.AddressRepository;
import com.github.fporto.design_patterns_lab.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final ViaCepService viaCepService;

    public ClientServiceImpl(ClientRepository clientRepository, AddressRepository addressRepository, ViaCepService viaCepService) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
        this.viaCepService = viaCepService;
    }

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void save(Client client) {
        var addressZip = client.getAddress().getZip();
        var address = addressRepository.findAddressByZip(addressZip).orElseGet(() -> {
            var zip = addressZip.replace("-", "");
            var newAddress = viaCepService.findByZip(zip);
            var newZip = newAddress.getZip().replace("-", "");
            newAddress.setZip(newZip);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }

    @Override
    public void update(Long id, Client client) {
        clientRepository.findById(id).ifPresent(c -> {
            client.setId(id);
            save(client);
        });
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
