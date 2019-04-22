package com.tourfirm.controller;

import com.tourfirm.entity.Room;
import com.tourfirm.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/room")
    public String roomPage(Model model) {
        model.addAttribute("roomList", roomService.finaAll());
        return "room";
    }

    @RequestMapping(value = "addroom", method = RequestMethod.POST)
    public String saveRoom(@ModelAttribute("dispatcher") Room room, Model model) {
//        roomService.save(room);

        System.out.println(room.getRoomNumber());
        System.out.println(room.getNumberOfPlaces());
        System.out.println(room.getHotel().getHotelName());
        System.out.println(room.getRoomType().getType());
        model.addAttribute("roomList", roomService.finaAll());
        return "room";
    }

    @GetMapping("delete/{id}")
    public String deleteRoom(@PathVariable("id") String room) {
        System.out.println(room);
//        roomService.delete(room);
        return "redirect:/room";
    }

}
