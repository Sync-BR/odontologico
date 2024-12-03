package org.springframework.odontologico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Table(name = "historical", schema = "odontologicoDB")
@Entity(name = "historical")
public class HistoricalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "historical_doctor_name", nullable = false)
    private String doctorName;
    @Column(name = "historical_doctor_service", nullable = false)
    private String service;
    @Column(name = "historical_doctor_date", nullable = false)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnore
    private ClientModel client;

    public HistoricalModel() {
    }

    public HistoricalModel(String doctorName, String service, Date date, ClientModel client) {
        this.doctorName = doctorName;
        this.service = service;
        this.date = date;
        this.client = client;
    }
}
