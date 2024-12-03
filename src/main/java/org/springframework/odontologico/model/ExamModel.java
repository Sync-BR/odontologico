package org.springframework.odontologico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Getter
@Setter
@Entity(name = "Exame")
@Table(name = "Exam", schema = "odontologicodb")
public class ExamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "type_exam", nullable = false)
    private String exam_Type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_exam", nullable = false)
    private Date exam_Date;
    @Column(name = "note_exam", nullable = false)
    private String exam_Description;
    @Column(name = "exam_doctor", nullable = false)
    private String doctor_name;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @JsonIgnore
    @NotNull
    private ClientModel client;

    public ExamModel() {
        this.exam_Date = new Date();
    }

    @Override
    public String toString() {
        return "ExamModel{" +
                "id=" + id +
                ", exam_Type='" + exam_Type + '\'' +
                ", exam_Date=" + exam_Date +
                ", exam_Description='" + exam_Description + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                ", clientId=" + (client != null ? client.getId() : "null") +  
                '}';
    }
}
