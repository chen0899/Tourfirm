package com.tourfirm.controller;

import com.tourfirm.entity.Booking;
import com.tourfirm.entity.Room;
import com.tourfirm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private VisaService visaService;

    @GetMapping("/task")
    public String allTasks() {
        return "tasks";
    }

    @GetMapping("/task1")
    public String citiesAndCountries(Model model) {
        model.addAttribute("countryList", countryService.findAll());
        model.addAttribute("cityList", cityService.findAll());
        return "task1";
    }


    @GetMapping("/task2")
    public String hotelsByCityName() {
        return "task2";
    }

    @GetMapping("/task2-out")
    public String outHotels(@RequestParam String cityName, Model model) {
        model.addAttribute("hotelList", hotelService.findAllByCity(cityName));
        return "task2-out";
    }

    @GetMapping("/task3")
    public String visaByClientName() {
        return "task3";
    }

    @GetMapping("/task3-out")
    public String outVisa(@RequestParam String lastName, Model model) {
        model.addAttribute("visaList", visaService.findAllVisaByClient(lastName));
        return "task3-out";
    }

    @GetMapping("/task4")
    public String visaByCountryName() {
        return "task4";
    }


    @GetMapping("/task4-out")
    public String outVisaByCountry(@RequestParam String countryName, Model model) {
        model.addAttribute("visaList", visaService.findAllVisaByCountry(countryName));
        return "task4-out";

    }
}
