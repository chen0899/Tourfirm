package com.tourfirm.controller;

import com.tourfirm.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Illia Chenchak
 */
@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public String countryList(Model model) {
        model.addAttribute("countryList",countryService.finaAll());
        return "country";
    }
}
