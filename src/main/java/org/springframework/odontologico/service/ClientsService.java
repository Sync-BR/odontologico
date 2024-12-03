package org.springframework.odontologico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.odontologico.model.ClientModel;
import org.springframework.odontologico.repository.ClientsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository clientsRepository;

    public ClientModel addClients(ClientModel clientModel) {
        return clientsRepository.save(clientModel);
    }
    public ClientModel findByCpf(String cpf) {
        return clientsRepository.findByCpf(cpf);
    }
    public Long countClients() {
       return  clientsRepository.count();
    }

    public List<ClientModel> getAllClients() {
        return clientsRepository.findAll();
    }

    public ClientModel getClientByCpf(String cpf) {
        return clientsRepository.findByCpf(cpf);
    }


}
