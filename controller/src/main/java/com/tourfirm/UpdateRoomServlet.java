package com.tourfirm;

import com.toufirm.Room;
import com.tourfirm.impl.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-room")
public class UpdateRoomServlet extends HttpServlet {

    private RoomService roomService = new RoomServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long roomId = Long.valueOf(request.getParameter("edit"));
        request.setAttribute("room", roomService.findById(roomId));
        request.getRequestDispatcher("WEB-INF/jsp/RoomEditor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long roomId = Long.valueOf(request.getParameter("id"));
        Long numberRoom = Long.valueOf(request.getParameter("roomNumber"));
        Integer countPlace = Integer.valueOf(request.getParameter("countPlace"));
        String hotelName =request.getParameter("hotelName");
        String roomType = request.getParameter("roomType");

        Room room = new Room();
        room.setId(roomId);
        room.setRoomNumber(numberRoom);
        room.setNumberOfPlaces(countPlace);
        roomService.update(room, hotelName, roomType);

        response.sendRedirect(request.getContextPath() + "/room");
    }
}
