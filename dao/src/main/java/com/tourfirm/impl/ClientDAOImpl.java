package com.tourfirm.impl;

import com.toufirm.Client;
import com.toufirm.Country;
import com.toufirm.Room;
import com.tourfirm.ClientDAO;
import com.tourfirm.MySQLDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Illia Chenchak
 */
public class ClientDAOImpl implements ClientDAO {

    @Override
    public Client getUserById(Integer id) {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Client result = null;

        String query = "SELECT Clients.id, Clients.firstname, Clients.lastname, Clients.e_mail, " +
                "Clients.phone, Country.id, Country.country_name " +
                "FROM Clients left join Country on Clients.id_country = Country.id " +
                "where Clients.id ="+id+" " +
                "order by Clients.firstname;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
            result = new Client();
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getLong("id"));
                client.setFirstName(resultSet.getString("firstname"));
                client.setLastName(resultSet.getString("lastname"));
                client.setEmail(resultSet.getString("e_mail"));
                client.setPhone(resultSet.getString("phone"));
                client.setCountry(new Country(resultSet.getLong("id"),resultSet.getString("country_name")));
                result = client;
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closeQuietly(stmt);
            factory.closeQuietly(connection);
        }
        factory.closeConnection(connection);
        return result;
    }

    @Override
    public List<Client> findAll() {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        List<Client> result = null;

        String query = "SELECT Clients.id, Clients.firstname, Clients.lastname, Clients.e_mail, " +
                "Clients.phone, Country.id, Country.country_name " +
                "FROM Clients left join Country on Clients.id_country = Country.id " +
                "order by Clients.firstname;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
            result = new ArrayList<>();
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getLong("id"));
                client.setFirstName(resultSet.getString("firstname"));
                client.setLastName(resultSet.getString("lastname"));
                client.setEmail(resultSet.getString("e_mail"));
                client.setPhone(resultSet.getString("phone"));
                client.setCountry(new Country(resultSet.getLong("id"),resultSet.getString("country_name")));
                result.add(client);
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closeQuietly(stmt);
            factory.closeQuietly(connection);
        }
        factory.closeConnection(connection);
        return result;
    }

    @Override
    public void save(Client client) {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        String query = "INSERT INTO Client(id,firstname,lastname,e_mail,phone,id_country) " +
                "value("+client.getId()+","+client.getFirstName()+","+client.getLastName()+","+
                client.getEmail()+","+client.getPhone()+","+client.getCountry().getId()+");";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        try {
            stmt = connection.prepareStatement(query);
            System.out.println("Save "+client);
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closeQuietly(stmt);
            factory.closeQuietly(connection);
        }
        factory.closeConnection(connection);
    }
}
