package org.springframework.odontologico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.odontologico.model.ClientModel;
import org.springframework.odontologico.service.ClientsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ClientsController {
    @Autowired
    private ClientsService service;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @GetMapping("/api/user/getAllUsers")
    public List<ClientModel> getAllUsers() {
        return service.getAllClients();
    }

    @PostMapping("/api/user/create")
    public String registerClients(ClientModel client, RedirectAttributes redirectAttributes) {
        ClientModel clientCopy = service.findByCpf(client.getCpf());
        if (clientCopy == null) {
            if (service.addClients(client) != null) {
                redirectAttributes.addFlashAttribute("message", "Cliente cadastrado com sucesso!!");
            } else {
                redirectAttributes.addFlashAttribute("messageErro", "Ocorreu um erro inesperado. Tente novamente.");
            }
        } else {
            redirectAttributes.addFlashAttribute("messageErro", "CPF já cadastrado. Verifique os dados e tente novamente.");
        }
        return "redirect:/registrar";
    }

    @PostMapping("/api/user/findByCpf")
    public String getClientByCpf( @RequestParam("cpf") String cpf, RedirectAttributes redirectAttributes) {
        ClientModel clientCopy = service.findByCpf(cpf);
        System.out.println("Log: " +clientCopy);
        if (clientCopy != null) {
            redirectAttributes.addFlashAttribute("clientDate", clientCopy);
        } else {
            redirectAttributes.addFlashAttribute("clientDate", null);
            redirectAttributes.addFlashAttribute("message", "Cliente não encontrado. Verifique o CPF e tente novamente.");        }
        return "redirect:/";
    }

}
