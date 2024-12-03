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
        System.out.println("passei");
        ClientModel clientCopy = service.findByCpf(client.getCpf());
        if (clientCopy == null) {
            if (service.addClients(client) != null) {
                redirectAttributes.addFlashAttribute("message", "Usuario cadastrado com sucesso!");
            } else {
                redirectAttributes.addFlashAttribute("messageErro", "Erro desconhecido");
            }
        } else {
            redirectAttributes.addFlashAttribute("messageErro", "Cpf já cadastrado!!");
        }
        return "redirect:/registrar";
    }

    @PostMapping("/api/user/findByCpf")
    public String getClientByCpf( @RequestParam("cpf") String cpf, RedirectAttributes redirectAttributes) {
        System.out.println("Log: " +cpf);
        ClientModel clientCopy = service.findByCpf(cpf);
        System.out.println("Log: " +clientCopy);
        if (clientCopy != null) {
            redirectAttributes.addFlashAttribute("clientDate", clientCopy);
        } else {
            redirectAttributes.addFlashAttribute("clientDate", null);
            redirectAttributes.addFlashAttribute("message", "Cliente não encontrado!");        }
        return "redirect:/";
    }

}
