package org.springframework.odontologico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.odontologico.model.ExamModel;
import org.springframework.odontologico.model.HistoricalModel;
import org.springframework.odontologico.repository.ExamsRepository;
import org.springframework.odontologico.repository.HistoricalRepository;
import org.springframework.stereotype.Service;

@Service
public class ExamsService {
    @Autowired
    private ExamsRepository examsRepository;
    @Autowired
    private HistoricalRepository historicalRepository;

    public boolean createExams(ExamModel exam) {
        ExamModel examCopy = examsRepository.save(exam);
        if (examCopy.getId() != 0) {
            HistoricalModel addHistorical = new HistoricalModel(exam.getDoctor_name(), exam.getExam_Type(), exam.getExam_Date(), exam.getClient());
            HistoricalModel historicalCopy = historicalRepository.save(addHistorical);
            if(historicalCopy.getId() != 0) {
                return true;
            }
        }
        return false;
    }

    public Long getExams() {
        return examsRepository.count();
    }
}
