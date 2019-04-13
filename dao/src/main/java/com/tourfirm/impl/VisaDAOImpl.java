package com.tourfirm.impl;

import com.toufirm.Client;
import com.toufirm.Visa;
import com.tourfirm.VisaDAO;
import com.tourfirm.MySQLDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VisaDAOImpl implements VisaDAO {


    @Override
    public Visa getVisaById(Integer id) {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Visa result = null;

        String query = "SELECT * FROM Visa where Visa.id =" + id + " ;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();


        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
            result = new Visa();
            while (resultSet.next()) {
                Visa visa = new Visa();
              CountryDAOImpl countryDAO = new CountryDAOImpl();
              ClientDAOImpl  clientDAO = new ClientDAOImpl();
                visa.setId(resultSet.getInt("id"));
                visa.setStartDate(resultSet.getDate("start_date"));
                visa.setEndDate(resultSet.getDate("end_date"));
                visa.setClient( clientDAO.getUserById(resultSet.getInt("id_client")));
                visa.setCountry( countryDAO.getCountryById(resultSet.getInt("id_country")));
                result = visa;
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            //  factory.closeQuietly(stmt);
            // factory.closeQuietly(connection);
        }
        factory.closeConnection(connection);
        return result;
    }

    @Override
    public List<Visa> findAll() {

        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        List<Visa> result = null;

        String query = "SELECT * FROM Visa;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();


        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
            result = new ArrayList<>();
            while (resultSet.next()) {
                Visa visa = new Visa();
                CountryDAOImpl countryDAO = new CountryDAOImpl();
                ClientDAOImpl  clientDAO = new ClientDAOImpl();
                visa.setId(resultSet.getInt("id"));
                visa.setStartDate(resultSet.getDate("start_date"));
                visa.setEndDate(resultSet.getDate("end_date"));
                visa.setClient( clientDAO.getUserById(resultSet.getInt("id_client")));
                visa.setCountry( countryDAO.getCountryById(resultSet.getInt("id_country")));
                result.add(visa);
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            //  factory.closeQuietly(stmt);
            // factory.closeQuietly(connection);
        }
        factory.closeConnection(connection);
        return result;
    }

    @Override
    public void save(Visa visa) {

        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        String query = "INSERT INTO Visa(id, start_date, end_date, id_client, id_country) " +
                "values(?, ?, ?,?,?);";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(query);
            stmt.setInt(1,visa.getId());
            stmt.setDate(2,visa.getStartDate());
            stmt.setDate(3,visa.getEndDate());
            stmt.setInt(4,visa.getClient().getId());
            stmt.setInt(5,visa.getCountry().getId());
            stmt.executeUpdate();
            connection.commit();
            System.out.println("Save " + visa);
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException excep) {
                    System.out.println(excep);
                }
            }
        } finally {
            // factory.closeQuietly(stmt);
            //  factory.closeQuietly(connection);
        }
        factory.closeConnection(connection);


    }
}
