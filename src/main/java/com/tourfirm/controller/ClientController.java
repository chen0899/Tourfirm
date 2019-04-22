package com.tourfirm.controller;

import com.tourfirm.service.ClientService;
import com.tourfirm.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Illia Chenchak
 */
@Controller
@RequestMapping("/")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CountryService countryService;


    @GetMapping("/client")
    public String clientList(Model model) {
        model.addAttribute("clientList",clientService.findAll());
        return "client";
    }
}
