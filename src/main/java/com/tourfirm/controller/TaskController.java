package com.tourfirm.controller;

import com.tourfirm.service.CityService;
import com.tourfirm.service.CountryService;
import com.tourfirm.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private HotelService hotelService;

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


    @GetMapping("/task2")
    public String hotelsByCityName(){
        return "task2";
    }

    @GetMapping("/task2-out")
    public String outHotels(@RequestParam String cityName, Model model){
        model.addAttribute("hotelList",hotelService.findAllByCity(cityName));
        return "task2-out";
    }
}
