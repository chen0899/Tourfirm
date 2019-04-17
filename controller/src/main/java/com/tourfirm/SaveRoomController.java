package com.tourfirm;

import com.toufirm.Room;
import com.tourfirm.impl.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save-room")
public class SaveRoomController extends HttpServlet {

    private RoomService roomService = new RoomServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long numberRoom = Long.valueOf(request.getParameter("roomNumber"));
        Integer countPlace = Integer.valueOf(request.getParameter("countPlace"));
        String hotelName =request.getParameter("hotelName");
        String roomType = request.getParameter("roomType");

        Room room = new Room();
        room.setRoomNumber(numberRoom);
        room.setNumberOfPlaces(countPlace);
        roomService.save(room, hotelName, roomType);
        response.sendRedirect(request.getContextPath() + "/room");
    }
}
