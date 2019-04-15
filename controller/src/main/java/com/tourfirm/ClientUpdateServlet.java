package com.tourfirm;

import com.toufirm.Client;
import com.tourfirm.impl.ClientServiceImpl;
import com.tourfirm.impl.CountryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Illia Chenchak
 */
@WebServlet("/update-client")
public class ClientUpdateServlet extends HttpServlet {

    private ClientService clientService = new ClientServiceImpl();

    private CountryService countryService = new CountryServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String e_mail = request.getParameter("email");
        String phone = request.getParameter("phone");
        String countryName = request.getParameter("countryName");


        Client client = new Client();
        client.setId(id);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(e_mail);
        client.setPhone(phone);
        client.setCountry(countryService.findByCountryName(countryName));
        clientService.update(client);
        response.sendRedirect(request.getContextPath() + "/client");
    }
}
