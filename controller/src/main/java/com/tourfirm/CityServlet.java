package com.tourfirm;

import com.toufirm.City;
import com.tourfirm.impl.CityServiceImpl;
import com.tourfirm.impl.CountryServiceImpl;
import com.tourfirm.impl.HotelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/city")
public class CityServlet extends HttpServlet {
    private CityServiceImpl cityService = new CityServiceImpl();
    private HotelServiceImpl hotelService = new HotelServiceImpl();
    private City city = new City();
    private CountryServiceImpl countryService = new CountryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cityList", cityService.findAll());
        req.setAttribute("hotelList", hotelService.findAll());
        req.getRequestDispatcher("WEB-INF/jsp/City.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("cityiddel"));
        System.out.println("id = " + id);
        cityService.delete(id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        city.setId(Integer.parseInt(req.getParameter("cityID")));
        city.setCityName(req.getParameter("cityName"));
        city.setCountry(countryService.findAll().get(1));
        cityService.update(city.getId(), city);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String s = req.getParameter("todo");
        System.out.println(s);
        if (s.equals("Delete")) {
            System.out.println(s);
            doDelete(req, resp);
        }
        if (s.equals("Update")) {
            System.out.println(s);
            doPut(req, resp);
        }
        if (s.equals("Create")) {
            city.setCityName(req.getParameter("cityName"));
            city.setCountry(countryService.findAll().get(1));
            cityService.save(city);
        }
    }
}
