package com.tourfirm;

import com.tourfirm.impl.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Illia Chenchak
 */
@WebServlet("/client")
public class ClientServlet extends HttpServlet {
    private ClientService clientService = new ClientServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("clientList", clientService.findAll());

        request.getRequestDispatcher("WEB-INF/jsp/Client.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("delete"));
        clientService.delete(id);
        resp.sendRedirect(req.getContextPath()+ "/client");
    }
}
