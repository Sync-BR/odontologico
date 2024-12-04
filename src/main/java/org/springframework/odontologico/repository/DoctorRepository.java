package org.springframework.odontologico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.odontologico.model.DoctorModel;

public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {
    DoctorModel findByCpf(String cpf);
}
