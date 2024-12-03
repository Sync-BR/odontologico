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

    public List<DoctorModel> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
