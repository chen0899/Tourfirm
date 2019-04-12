package com.tourfirm.impl;

import com.toufirm.Client;
import com.toufirm.Country;
import com.tourfirm.ClientDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Illia Chenchak
 */
public class Main {
    public static void main(String[] args) {
        ClientDAOImpl clientDAO = new ClientDAOImpl();
        List<Client> clients = clientDAO.findAll();
        clients.stream().forEach(client -> System.out.println(client));

        Client client2 = clientDAO.getUserById(1);
        System.out.println(client2);

        CountryDAOImpl countryDAO = new CountryDAOImpl();
        List<Country> countries = countryDAO.findAll();
        countries.stream().forEach(country -> System.out.println(country));

        Country country2 = countryDAO.getCountryById(1);
        System.out.println(country2);

        System.out.println("save:");
        System.out.println("---------------------------");
        Client client3 = new Client((long) 5,"Ivan","Petrovich","e@gmail.com","00000",countryDAO.getCountryById(1));
        clientDAO.save(client3);
    }
}
