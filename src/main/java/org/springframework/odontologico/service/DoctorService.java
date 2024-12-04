package org.springframework.odontologico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.odontologico.model.DoctorModel;
import org.springframework.odontologico.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Long getCountDoctores(){
        return doctorRepository.count();
    }

    // Retornar true caso existar um usuario registrado
    private boolean findCpf(String cpf) {
        DoctorModel doctor = doctorRepository.findByCpf(cpf);
        if(doctor != null) {
            return true;
        }
        return false;
    }
    public List<DoctorModel> getAllDoctors() {
        return doctorRepository.findAll();
    }
    // Retorna true se o usuário for criado.
    public boolean CreateDoctor(DoctorModel doctor) {
        if(!findCpf(doctor.getCpf())) {
            doctorRepository.save(doctor);
            return true;
        }
        return false;
    }
}
