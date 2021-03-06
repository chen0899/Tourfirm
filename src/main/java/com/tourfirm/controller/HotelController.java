package com.tourfirm.controller;

import com.tourfirm.entity.Hotel;
import com.tourfirm.service.CityService;
import com.tourfirm.service.HotelService;
import com.tourfirm.service.ValidationHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private CityService cityService;

    @Autowired
    private ValidationHotelService validation;

    @GetMapping("/hotel")
    public String findAllHotels(Model model) {
        model.addAttribute("cityList", cityService.findAll());
        model.addAttribute("hotelList", hotelService.finaAll());
        return "hotel";
    }

    @PostMapping("/save-hotel")
    public String save(@RequestParam String hotelName, @RequestParam String email,
                       @RequestParam String phone, @RequestParam Integer city,
                       @RequestParam String address, Model model) {

        checkData(hotelName, email, phone, city, address, model);

        if (!model.asMap().isEmpty()){
            model.addAttribute("cityList", cityService.findAll());
            model.addAttribute("hotelList", hotelService.finaAll());
            model.addAttribute("notEmpty", "notEmpty");
            model.addAttribute("hotel", getHotel(hotelName, email, phone, city, address));
            return "hotel";
        }

        Hotel hotel = getHotel(hotelName, email, phone, city, address);

        hotelService.save(hotel);
        return "redirect:/hotel";
    }

    @PostMapping("update-hotel/{id}")
    public String hotelEditForm(@PathVariable("id") Long id, Model model) {
        Hotel hotelDB = hotelService.findById(id);
        model.addAttribute("cityList", cityService.findAll());
        model.addAttribute("hotel", hotelDB);
        return "hotel-editor";
    }

    @PostMapping("/update-hotel")
    public String update(@RequestParam Long id, @RequestParam String hotelName, @RequestParam String email,
                         @RequestParam String phone, @RequestParam Integer city, @RequestParam String address) {
        Hotel hotel = getHotel(hotelName, email, phone, city, address);
        hotel.setId(id);
        hotelService.update(hotel);
        return "redirect:/hotel";
    }

    @PostMapping("/delete-hotel/{id}")
    public String delete(@PathVariable("id") Long roomId) {
        Hotel hotelDB = hotelService.findById(roomId);
        hotelService.delete(hotelDB);
        return "redirect:/hotel";
    }

    private void checkData(String hotelName, String email, String phone, Integer city, String address, Model model) {
        if (validation.isPresentHotelByName(hotelName, city)) {
            model.addAttribute("nameError", "Hotel with the same name is present in system");
        }

        if (validation.isPresentHotelByEmail(email)) {
            model.addAttribute("emailError", "Hotel with the same email is present in system");
        }

        if (validation.isPresentHotelByPhone(phone)) {
            model.addAttribute("phoneError", "Hotel with the same phone is present in system");
        }
        if (validation.isPresentHotelByAddress(address, city)) {
            model.addAttribute("addressError", "Hotel with the same address is present in system");
        }
    }

    private Hotel getHotel(String hotelName, String email, String phone, Integer city, String address) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelName);
        hotel.setEmail(email);
        hotel.setPhone(phone);
        hotel.setCity(cityService.findById(city));
        hotel.setAddress(address);
        return hotel;
    }
}
