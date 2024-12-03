package org.springframework.odontologico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.odontologico.model.HistoricalModel;

public interface HistoricalRepository extends JpaRepository<HistoricalModel, Long> {
}
