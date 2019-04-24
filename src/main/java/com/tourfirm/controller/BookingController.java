package com.tourfirm.controller;

import com.tourfirm.entity.Booking;
import com.tourfirm.service.BookingService;
import com.tourfirm.service.ClientService;
import com.tourfirm.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

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
    public String bookinList(Model model) {
        model.addAttribute("clientList",clientService.findAll());
        model.addAttribute("roomList",roomService.finaAll());
        model.addAttribute("bookingList", bookingService.findAll());
        return "booking";
    }

    @PostMapping("/save-booking")
    public String saveBooking(@RequestParam Date startDate, @RequestParam Date endDate,
                              @RequestParam String clientId, @RequestParam String roomId) {
        Booking booking = new Booking();
        booking.setStartDate(startDate);
        booking.setEndDate((endDate));
        booking.setClient(clientService.findById(Integer.valueOf(clientId)));
        booking.setRoom(roomService.findById(Integer.parseInt(roomId)));
        bookingService.save(booking);
        return "redirect:/booking";
    }

    @PostMapping("/delete-booking/{id}")
    public String deleteBooking(@PathVariable("id") Integer id) {
        bookingService.delete(id);
        return "redirect:/booking";
    }

    @PostMapping("update-form-booking/{id}")
    public String bookingFormUpdate(@PathVariable("id") Integer id, Model model) {
        Booking booking = bookingService.findById(id);
        model.addAttribute("booking", booking);
        model.addAttribute("clientList",clientService.findAll());
        model.addAttribute("roomList",roomService.finaAll());
        return "booking-editor";
    }

    @PostMapping("update-booking")
    public String bookingUpdate(@RequestParam Integer id, @RequestParam Date startDate, @RequestParam Date endDate,
                                @RequestParam String clientId, @RequestParam String roomId) {
        Booking booking = new Booking();
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setClient(clientService.findById(Integer.parseInt(clientId)));
        booking.setRoom(roomService.findById(Integer.parseInt(roomId)));
        bookingService.update(id, booking);
        return "redirect:/booking";
    }
}
