package org.springframework.odontologico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.odontologico.model.ClientModel;
import org.springframework.odontologico.repository.ClientsRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository clientsRepository;

    public ClientModel addClients(ClientModel clientModel) {
        return clientsRepository.save(clientModel);
    }
}
