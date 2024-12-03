package org.springframework.odontologico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.odontologico.model.ClientModel;

public interface ClientsRepository extends JpaRepository<ClientModel, Long> {
    ClientModel findByCpf(String cpf);

}
