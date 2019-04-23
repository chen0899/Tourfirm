package com.tourfirm.controller;

import com.tourfirm.entity.Hotel;
import com.tourfirm.entity.Room;
import com.tourfirm.entity.RoomType;
import com.tourfirm.service.HotelService;
import com.tourfirm.service.RoomService;
import com.tourfirm.service.RoomTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class RoomController {
    private final RoomTypeService roomTypeService;
    private final HotelService hotelService;
    private final RoomService roomService;

    public RoomController(RoomTypeService roomTypeService, HotelService hotelService, RoomService roomService) {
        this.roomTypeService = roomTypeService;
        this.hotelService = hotelService;
        this.roomService = roomService;
    }

    @GetMapping("/room/{id}")
    public String roomPages(@PathVariable("id") Long id, Model model) {
        List<Room> allByHotelId = roomService.findAllByHotelId(id);
        model.addAttribute("roomList", allByHotelId);
        model.addAttribute("hotel", hotelService.findById(id));
        model.addAttribute("typesList", roomTypeService.finaAll());
        return "room";
    }

    @PostMapping("/room-save")
    public String saveRoom(@RequestParam Integer roomNumber, @RequestParam Integer numberOfPlaces,
                           @RequestParam String hotel, @RequestParam String roomType,
                           @RequestParam Long hotelId) {
        Room room = getRoom(roomNumber, numberOfPlaces, hotel, roomType);
        roomService.save(room);
        return "redirect:/room/" + hotelId;
    }

    @PostMapping("/update-room/{id}")
    public String roomEditForm(@PathVariable("id") Integer id, Model model) {
        Room roomDB = roomService.findById(id);
        model.addAttribute("typesList", roomTypeService.finaAll());
        model.addAttribute("room", roomDB);
        return "room-editor";
    }

    @PostMapping("/update-room")
    public String roomUpdate(@RequestParam Integer id, @RequestParam Integer roomNumber,
                             @RequestParam Integer numberOfPlaces, @RequestParam String hotel,
                             @RequestParam String roomType, @RequestParam Long hotelId) {
        Room room = getRoom(roomNumber, numberOfPlaces, hotel, roomType);
        room.setId(id);
        roomService.update(room);
        return "redirect:/room/" + hotelId;
    }

    @PostMapping("delete/{id}")
    public String deleteRoom(@PathVariable("id") Integer roomId, @RequestParam Long hotelId) {
        Room roomById = roomService.findById(roomId);
        roomService.delete(roomById);
        return "redirect:/room/" + hotelId;
    }

    private Room getRoom(Integer roomNumber, Integer numberOfPlaces, String hotel, String roomType) {
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setNumberOfPlaces(numberOfPlaces);
        room.setHotel(getByHotelName(hotel));
        room.setRoomType(getRoomType(roomType));
        return room;
    }

    private Hotel getByHotelName(String hotel) {
        return hotelService.findByName(hotel);
    }

    private RoomType getRoomType(String roomType) {
        return roomTypeService.findByName(roomType);
    }

}
