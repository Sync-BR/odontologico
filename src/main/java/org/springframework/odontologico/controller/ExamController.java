package org.springframework.odontologico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.odontologico.model.ExamModel;
import org.springframework.odontologico.service.ExamsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ExamController {
    @Autowired
    private ExamsService service;

    @PostMapping("/api/exam/register")
    public String registerExam(ExamModel exam, RedirectAttributes redirectAttributes) {
        System.out.println(exam.toString());
        if (service.createExams(exam)) {
            System.out.println("Sucesso!");
        } else {
            System.out.println("Falha!");
        }
        return "redirect:/exames";
    }

}
