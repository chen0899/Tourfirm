package com.tourfirm.impl;

import com.toufirm.Client;
import com.toufirm.Country;
import com.toufirm.Room;
import com.tourfirm.ClientDAO;
import com.tourfirm.MySQLDAOFactory;

import java.sql.*;
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

        String query = "SELECT clients.id, clients.firstname, clients.lastname, clients.e_mail, " +
                "clients.phone, country.id, country.country_name " +
                "FROM clients left join country on clients.id_country = country.id " +
                "where clients.id =" + id + " " +
                "order by clients.firstname;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
            result = new Client();
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setFirstName(resultSet.getString("firstname"));
                client.setLastName(resultSet.getString("lastname"));
                client.setEmail(resultSet.getString("e_mail"));
                client.setPhone(resultSet.getString("phone"));
                client.setCountry(new Country(resultSet.getInt("id"), resultSet.getString("country_name")));
                result = client;
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(stmt);
            factory.closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Client> findAll() {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        List<Client> result = null;

        String query = "SELECT clients.id, clients.firstname, clients.lastname, clients.e_mail, " +
                "clients.phone, country.id, country.country_name " +
                "FROM clients left join country on clients.id_country = country.id " +
                "order by clients.id;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
            result = new ArrayList<>();
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setFirstName(resultSet.getString("firstname"));
                client.setLastName(resultSet.getString("lastname"));
                client.setEmail(resultSet.getString("e_mail"));
                client.setPhone(resultSet.getString("phone"));
                client.setCountry(new Country(resultSet.getInt("id"), resultSet.getString("country_name")));
                result.add(client);
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(stmt);
            factory.closeConnection(connection);
        }
        return result;
    }

    @Override
    public void save(Client client) {
        PreparedStatement stmt = null;

        String query = "INSERT INTO clients(id,firstname,lastname,e_mail,phone,id_country) " +
                "values(?,?,?,?,?);";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, client.getFirstName());
            stmt.setString(2, client.getLastName());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getPhone());
            stmt.setInt(5, client.getCountry().getId());
            stmt.executeUpdate();
            connection.commit();
            System.out.println("save:" + client);
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
            factory.rollbackQuietlyConn(connection);
        } finally {
            factory.closePreparedStatement(stmt);
            factory.closeConnection(connection);
        }
    }

    @Override
    public void update(Client client) {
        PreparedStatement stmt = null;
        final char dm = (char) 34;

        String query = "UPDATE clients " +
                "SET firstname =  "+ dm +client.getFirstName()+ dm +
                ", lastname = "+ dm + client.getLastName() + dm +
                ", e_mail = "  + dm + client.getEmail() + dm +
                ", phone = " + dm + client.getPhone() + dm +
                ", id_country = " + client.getCountry().getId() +
                " WHERE clients.id = "+client.getId()+" ;";


        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
            connection.commit();
            System.out.println("Update client where id= " + client.getId());
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
            factory.rollbackQuietlyConn(connection);

        } finally {
            factory.closePreparedStatement(stmt);
            factory.closeConnection(connection);
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement stmt = null;

        String query = "DELETE FROM clients WHERE clients.id = " + id + " ;";


        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
            connection.commit();
            System.out.println("Delete clients where id=" + id);
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
            factory.rollbackQuietlyConn(connection);

        } finally {
            factory.closePreparedStatement(stmt);
            factory.closeConnection(connection);
        }
    }
}

