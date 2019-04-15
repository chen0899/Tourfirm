package com.tourfirm;

import com.tourfirm.impl.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/room")
public class RoomServlet extends HttpServlet {

    private RoomService roomService = new RoomServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("roomList", roomService.findAllByHotelName("Ocean Plaza"));

        request.getRequestDispatcher("WEB-INF/jsp/Room.jsp").forward(request, response);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("WEB-INF/jsp/Room.jsp").forward(request, response);
//    }
}
