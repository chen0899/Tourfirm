package com.tourfirm.impl;

import com.toufirm.Client;
import com.toufirm.Visa;
import com.tourfirm.VisaDAO;
import com.tourfirm.MySQLDAOFactory;

import java.sql.*;
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


        String query = "INSERT INTO Visa( start_date, end_date, id_client, id_country) " +
                "values( ?, ?,?,?);";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(query);
            stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setDate(1,visa.getStartDate());
            stmt.setDate(2,visa.getEndDate());
            stmt.setInt(3,visa.getClient().getId());
            stmt.setInt(4,visa.getCountry().getId());
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
            factory.closePreparedStatement(stmt);
            factory.closeConnection(connection);
        }
        factory.closeConnection(connection);


    }
}
