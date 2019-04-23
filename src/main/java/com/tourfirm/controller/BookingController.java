package com.tourfirm.controller;

import com.tourfirm.entity.Booking;
import com.tourfirm.service.BookingService;
import com.tourfirm.service.ClientService;
import com.tourfirm.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Illia Chenchak
 */
@Controller
@RequestMapping("/")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private RoomService roomService;

    @GetMapping("/booking")
    public String clientList(Model model) {
        model.addAttribute("bookingList",bookingService.findAll());
        return "booking";
    }

    @PostMapping("/save-booking")
    public String saveCountry(@RequestParam Date startDate, @RequestParam Date endDate,
                              @RequestParam Integer cleintId, @RequestParam Integer roomId) {
        Booking booking = new Booking();
        booking.setStartDate((java.sql.Date) startDate);
        booking.setEndDate((java.sql.Date) startDate);
        booking.setClient(clientService.findById(cleintId));
        booking.setRoom(roomService.findById(roomId));
        bookingService.save(booking);
        return "redirect:/booking";
    }

    @PostMapping("/delete-booking/{id}")
    public String deleteCountry(@PathVariable("id") Integer id, Model model) {
        bookingService.delete(id);
        return "redirect:/booking";
    }

}
