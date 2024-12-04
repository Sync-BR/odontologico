package org.springframework.odontologico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.odontologico.model.DoctorModel;
import org.springframework.odontologico.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService service;
    @PostMapping("/api/doctor/creater")
    public String create(DoctorModel doctorModel, RedirectAttributes redirectAttributes) {
        if (service.CreateDoctor(doctorModel)) {
            redirectAttributes.addFlashAttribute("message", "Funcionário cadastrado com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("messageErro", "CPF já cadastrado. Verifique os dados e tente novamente.");
        }

        return "redirect:/doctor";
    }
}
