package com.tourfirm.controller;

import com.tourfirm.entity.Hotel;
import com.tourfirm.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel")
    public String findAllHotels(Model model) {
        model.addAttribute("hotelList", hotelService.finaAll());
        return "hotel";
    }

    @PostMapping("update-hotel/{id}")
    public String companyEditForm(@PathVariable("id") Long id, Model model) {
        Hotel hotelDB = hotelService.findById(id);
        model.addAttribute("hotel", hotelDB);
        return "hotel-editor";
    }

}
