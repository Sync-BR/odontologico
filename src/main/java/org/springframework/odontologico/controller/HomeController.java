package org.springframework.odontologico.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.odontologico.service.ClientsService;
import org.springframework.odontologico.service.DoctorService;
import org.springframework.odontologico.service.ExamsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    ClientsService serviceClient;
    @Autowired
    DoctorService serviceDoctor;
    @Autowired
    ExamsService serviceExam;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("totalClientsCount", serviceClient.countClients().toString());
        model.addAttribute("totalExamsCount", serviceExam.getExams().toString());
        model.addAttribute("totalDoctorsCount", serviceDoctor.getCountDoctores().toString());
        return "index";
    }
    @GetMapping("/registrar")
    public String register( Model model) {
        return "registercliente";
    }
    @GetMapping("/exames")
    public String registerexam(Model model) {
        model.addAttribute("clients", serviceClient.getAllClients());
        model.addAttribute("doctors", serviceDoctor.getAllDoctors());
        return "registerexam";
    }
    @GetMapping("/doctor")
    public String registerdoctor() {
        return "registerdoctor";
    }
}
