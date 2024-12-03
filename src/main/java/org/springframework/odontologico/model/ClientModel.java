package org.springframework.odontologico.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "cliente")
@Table(name = "clientes", schema = "odontologicodb")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cliente_name", nullable = false)
    private String name;
    @Column(name = "cliente_cpf", nullable = false)
    private String cpf;
    @Column(name = "cliente_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Column(name = "cliente_telephone", nullable = false)
    private String telephone;
    @Column(name = "cliente_email", nullable = false)
    private String email;
    @Column(name = "cliente_cep", nullable = false)
    private String cep;
    @Column(name = "cliente_house_number", nullable = false)
    private int houseNumber;
    @Column(name = "cliente_residence_letter", nullable = false)
    private char residenceLetter;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoricalModel> historicalModel;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExamModel> examsModel;;
    public ClientModel() {
    }

    @Override
    public String toString() {
        return "ClientModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", date=" + date +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", cep='" + cep + '\'' +
                ", houseNumber=" + houseNumber +
                ", residenceLetter=" + residenceLetter +
                ", historicalModel=" + historicalModel +
                ", examsModel=" + examsModel +
                '}';
    }
}

