package com.tourfirm.controller;

import com.tourfirm.entity.Country;
import com.tourfirm.entity.Room;
import com.tourfirm.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Illia Chenchak
 */
@Controller
@RequestMapping("/")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public String countryList(Model model) {
        model.addAttribute("countryList", countryService.findAll());
        return "country";
    }

    @PostMapping("/save-country")
    public String saveCountry(@ModelAttribute("dispatcher") Country country, Model model) {
        countryService.save(country);
        return "redirect:/country";
    }

    @PostMapping("/delete-country/{id}")
    public String deleteCountry(@PathVariable("id") Integer id, Model model) {
        countryService.delete(id);
        return "redirect:/country";
    }

    @PostMapping("update-form-country/{id}")
    public String countryEditorFrom(@PathVariable("id") Integer id, Model model) {
        Country country = countryService.findById(id);
        model.addAttribute("country", country);
        return "country-editor";
    }

    @PostMapping("update-country")
    public String countryUpdate(@RequestParam Integer id, @RequestParam String countryName) {
        countryService.update(id, countryName);
        return "redirect:/country";
    }
}
