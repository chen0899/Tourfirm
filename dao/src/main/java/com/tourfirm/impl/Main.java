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
                CountryDAOImpl countryDAO = new CountryDAOImpl();
                Client client = new Client();

                client.setFirstName("Kolya");
                client.setLastName("Statis");
                client.setEmail("mail");
                client.setPhone("0000");

                client.setCountry(countryDAO.getCountryById(2));
                clientDAO.update(5,client);


//          clientDAO.delete(3);


//        List<Client> clients = clientDAO.findAll();
//        clients.stream().forEach(client -> System.out.println(client));
//
//        Client client2 = clientDAO.getUserById(1);
//        System.out.println(client2);


//        Country country = new Country();
//        country.setCountryName("Irland");
//        countryDAO.update(10,country);

                //countryDAO.delete(12);
//        List<Country> countries = countryDAO.findAll();
//        countries.stream().forEach(country -> System.out.println(country));
//
//        Country c = new Country();
//        c.setCountryName("DFS");

//        countryDAO.save(c);
                //  clientDAO.save(new Client(5,"Ivan","Pertiv","mail","0000",countryDAO.getCountryById(1)));

//        Country country2 = countryDAO.getCountryById(1);
//        System.out.println(country2);
//
//        Country c3 =new Country((long) 11,"Greec");
//        countryDAO.save(c3);
//        System.out.println(countryDAO.getCountryById(11));
//
//        System.out.println("save:");
//        System.out.println("---------------------------");
//        Client client3 = new Client((long) 5,"Ivan","Petrovich","e@gmail.com","00000",countryDAO.getCountryById(1));
//       // clientDAO.save(client3);
//        System.out.println(clientDAO.getUserById(5));
        }
}