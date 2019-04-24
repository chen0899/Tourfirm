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

    @PostMapping("/availeble-room")
    public String availebleRoom(@RequestParam Date startDate, @RequestParam Date endDate,
                                @RequestParam String clientId, @RequestParam String hotelId, Model model){

        List<Room> available = null;
        List<Booking> bookings = bookingService.findAll();
        List<Long> listId = new ArrayList<>();
        List<Room> rooms = roomService.findAllByHotelId(Long.parseLong(hotelId));
        for (Booking booking: bookings
             ) {

            listId.add(Long.valueOf(booking.getRoom().getId()));

        }



        return "book-room";
    }
}
