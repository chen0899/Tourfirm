package com.tourfirm.controller;


import com.tourfirm.entity.Visa;
import com.tourfirm.service.ClientService;
import com.tourfirm.service.CountryService;
import com.tourfirm.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Map;

@Controller
public class VisaController {

    @Autowired
    private VisaService visaService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private ClientService clientService;

    @RequestMapping("/visa")
    public String listContacts(Map<String, Object> map) {

        map.put("visa", new Visa());
        map.put("visaList", visaService.findAll());
        map.put("clientList", clientService.findAll());
        map.put("countryList", countryService.findAll());
        //System.out.println(visaService.findAll().get(0).toString());

        return "visa";
    }

    @PostMapping("/visa-save")
    public String saveRoom(@RequestParam Date startDate, @RequestParam Date endDate,
                           @RequestParam String country, @RequestParam String client) {

        visaService.save(startDate, endDate, client, country);
        return "redirect:/visa";
    }

    @PostMapping("update-visa/{id}")
    public String visaEdit(@PathVariable("id") Integer id, Model model) {
        Visa visaDB = visaService.findById(id);
        model.addAttribute("visa", visaDB);
        model.addAttribute("visaList", visaService.findAll());
        model.addAttribute("clientList", clientService.findAll());
        model.addAttribute("countryList", countryService.findAll());
        return "visa-editor";
    }

    @PostMapping("update-visa")
    public String visaUpdate(@RequestParam Integer id, @RequestParam Date startDate,
                             @RequestParam Date endDate, @RequestParam String countryName,
                             @RequestParam String clientName) {
        visaService.update(id, startDate, endDate, clientName, countryName);
        ;
        return "redirect:/visa";
    }


    @PostMapping("delete-visa/{id}")
    public String deleteRoom(@PathVariable("id") Integer visaId) {
        Visa visaById = visaService.findById(visaId);
        visaService.delete(visaById.getId());
        return "redirect:/visa";
    }


}
