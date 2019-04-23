
package com.tourfirm.controller;

import com.tourfirm.entity.City;
import com.tourfirm.entity.Country;
import com.tourfirm.service.CityService;
import com.tourfirm.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CityController {

    @Autowired
    private CityService cityService ;
    @Autowired
    private CountryService countryService;

    @RequestMapping("/city")
    public String listContacts(Map<String, Object> map) {

        map.put("city", new City());
        map.put("cityList", cityService.findAll());
        map.put("countryList", countryService.findAll());
        System.out.println(cityService.findAll().get(0).getCityName());

        return "city";
    }

    @RequestMapping("/save-city")
    public String saveCity(@ModelAttribute("dispatcher") City city,  Model model) {


        city.setCountry(countryService.findById(1));
        cityService.save(city);
        model.addAttribute("cityList",cityService.findAll());
        return "city";
    }

    @RequestMapping("/city/delete/{cityId}")
    public String deleteCity(@PathVariable("cityId") Integer cityId) {

        cityService.delete(cityId);

        return "redirect:/city";
    }


}
