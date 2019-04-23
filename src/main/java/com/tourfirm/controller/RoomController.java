package com.tourfirm.controller;

import com.tourfirm.entity.Hotel;
import com.tourfirm.entity.Room;
import com.tourfirm.entity.RoomType;
import com.tourfirm.service.HotelService;
import com.tourfirm.service.RoomService;
import com.tourfirm.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class RoomController {
    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private HotelService hotelService;

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/room")
    public String roomPage(Model model) {
        model.addAttribute("roomList", roomService.finaAll());
        return "room";
    }

    @GetMapping("/rooms/{id}")
    public String roomPages(@PathVariable("id") Long id, Model model) {
        model.addAttribute("roomList", roomService.findAllByHotelId(id));
        return "room";
    }


    @PostMapping("/room-save")
    public String saveRoom(@RequestParam Integer roomNumber, @RequestParam Integer numberOfPlaces,
                           @RequestParam String hotel, @RequestParam String roomType) {
        roomService.save(roomNumber, numberOfPlaces, hotel, roomType);
        return "redirect:/room";
    }

    @PostMapping("update-form/{id}")
    public String roomEditForm(@PathVariable("id") Integer id, Model model) {
        Room roomDB = roomService.findById(id);
        model.addAttribute("room", roomDB);
        return "room-editor";
    }

    @PostMapping("update-room")
    public String roomUpdate(@RequestParam Integer id, @RequestParam Integer roomNumber,
                             @RequestParam Integer numberOfPlaces, @RequestParam String hotel,
                             @RequestParam String roomType) {
        roomService.update(id, roomNumber, numberOfPlaces, hotel, roomType);
        return "redirect:/room";
    }

    @PostMapping("delete/{id}")
    public String deleteRoom(@PathVariable("id") Integer roomId) {
        Room roomById = roomService.findById(roomId);
        roomService.delete(roomById);
        return "redirect:/room";
    }

}
