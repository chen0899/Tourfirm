package com.tourfirm;

import com.sun.org.glassfish.external.statistics.CountStatistic;
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

@WebServlet("/save-country")
public class CountrySaveServlet extends HttpServlet {

    private CountryService countryService = new CountryServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String countryName =request.getParameter("countryName");

        Country country = new Country();
        country.setCountryName(countryName);
        countryService.save(country);
        response.sendRedirect(request.getContextPath() + "/country");
    }

}
