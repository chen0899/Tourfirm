package com.tourfirm.controller;

import com.tourfirm.service.CityService;
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
public class TaskController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;


    @GetMapping("/task")
    public String allTasks(){
        return "tasks";
    }

    @GetMapping("/task1")
    public String citiesAndCountries(Model model){
        model.addAttribute("countryList",countryService.findAll());
        model.addAttribute("cityList", cityService.findAll());
        return "task1";
    }
}
