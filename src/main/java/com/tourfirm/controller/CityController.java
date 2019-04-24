package com.tourfirm.controller;

import com.tourfirm.entity.City;
import com.tourfirm.service.CityService;
import com.tourfirm.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;

    @RequestMapping("/city")
    public String listContacts(Map<String, Object> map) {

        map.put("city", new City());
        map.put("cityList", cityService.findAll());
        map.put("countryList", countryService.findAll());
        map.put("countryNameList", countryService.findAll());
        System.out.println(cityService.findAll().get(0).getCityName());

        return "city";
    }

    @RequestMapping("/save-city")
    public String saveCity(@ModelAttribute("dispatcher") City city, Model model) {


        city.setCountry(countryService.findById(1));
        cityService.save(city);
        model.addAttribute("cityList", cityService.findAll());
        return "city";
    }

    @RequestMapping("/delete-city/{cityId}")
    public String deleteCity(@PathVariable("cityId") Integer cityId) {

        cityService.delete(cityId);

        return "redirect:/city";
    }

    @PostMapping("update-form-city/{id}")
    public String cityFromUpdate(@PathVariable("id") Integer id, Model model) {
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        model.addAttribute("countryList", countryService.findAll());
        return "city-editor";
    }

    @PostMapping("update-city")
    public String cityUpdate(@RequestParam Integer id, @RequestParam String cityName,
                             @RequestParam String countryName) {

        City city = new City();
        city.setId(id);
        city.setCityName(cityName);
        city.setCountry(countryService.findCountryByName(countryName));
        cityService.update(id, city);
        return "redirect:/city";
    }
}
