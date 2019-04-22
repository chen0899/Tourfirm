package com.tourfirm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {

    @GetMapping("/room")
    public String roomPage(Model model){
        return "room";
    }

}
