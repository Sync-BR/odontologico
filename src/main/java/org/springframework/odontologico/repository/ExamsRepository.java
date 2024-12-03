package org.springframework.odontologico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.odontologico.model.ExamModel;

public interface ExamsRepository extends JpaRepository<ExamModel, Long> {
}
