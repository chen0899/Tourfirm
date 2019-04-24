package com.tourfirm.controller;

import com.tourfirm.entity.Client;
import com.tourfirm.entity.Country;
import com.tourfirm.service.ClientService;
import com.tourfirm.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("clientList", clientService.findAll());
        model.addAttribute("countryNameList", countryService.findAll());
        return "client";
    }

    @PostMapping("/save-client")
    public String saveCountry(@RequestParam String firstName, @RequestParam String lastName,
                              @RequestParam String email, @RequestParam String phone,
                              @RequestParam String countryName) {
        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(email);
        client.setPhone(phone);
        client.setPhone(phone);
        client.setCountry(countryService.findCountryByName(countryName));

        clientService.save(client);
        return "redirect:/client";
    }

    @PostMapping("/delete-client/{id}")
    public String deleteCountry(@PathVariable("id") Integer id, Model model) {
        clientService.delete(id);
        return "redirect:/client";
    }

    @PostMapping("update-form-client/{id}")
    public String clientFormUpdate(@PathVariable("id") Integer id, Model model) {
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        model.addAttribute("countryNameList", countryService.findAll());
        return "client-editor";
    }

    @PostMapping("update-client")
    public String clientUpdate(@RequestParam Integer id, @RequestParam String firstName,
                               @RequestParam String lastName, @RequestParam String email,
                               @RequestParam String phone,
                               @RequestParam String countryName) {
        Client client = new Client();
        client.setId(id);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(email);
        client.setPhone(phone);
        client.setCountry(countryService.findCountryByName(countryName));
        clientService.update(id, client);
        return "redirect:/client";
    }
}
