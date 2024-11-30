package org.springframework.odontologico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.odontologico.model.ClientModel;
import org.springframework.odontologico.service.ClientsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/")
public class ClientsController {
    @Autowired
    private ClientsService service;
    @PostMapping("/api/user/create")
    public String registerClients(@RequestBody ClientModel client) {
        System.out.println(client);
        if(service.addClients(client) != null){
        }
        return "index";
    }

}
