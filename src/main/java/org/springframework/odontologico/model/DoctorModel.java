package org.springframework.odontologico.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Doctor")
@Table(name = "doctor", schema = "odontologicodb")
public class DoctorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "doctor_name", nullable = false)
    private String nome;
    @Column(name = "doctor_cpf", nullable = false)
    private String cpf;
    @Column(name = "doctor_specialization", nullable = false)
    private String specialization;
    @Column(name = "doctor_telephone", nullable = false)
    private String telephone;
    @Column(name = "doctor_email", nullable = false)
    private String email;

    public DoctorModel() {
    }
}
