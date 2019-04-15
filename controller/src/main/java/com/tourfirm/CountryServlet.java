package com.tourfirm;

import com.toufirm.Country;
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
@WebServlet("/country")
public class CountryServlet extends HttpServlet {

    private CountryService countryService = new CountryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("countryList", countryService.findAll());

        request.getRequestDispatcher("WEB-INF/jsp/Country.jsp").forward(request, response);
    }

}
