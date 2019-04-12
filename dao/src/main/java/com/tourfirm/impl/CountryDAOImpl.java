package com.tourfirm.impl;

import com.toufirm.Country;
import com.tourfirm.CountryDAO;
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
public class CountryDAOImpl implements CountryDAO {

    @Override
    public Country getCountryById(Integer id) {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Country result = null;

        String query = "SELECT * FROM COUNTRY where Country.id =" + id + " order by Country.country_name;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
            result = new Country();
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setCountryName(resultSet.getString("country_name"));
                result = country;
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
    public List<Country> findAll() {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        List<Country> result = null;

        String query = "SELECT * FROM Country order by Country.country_name;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
            result = new ArrayList<>();
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setCountryName(resultSet.getString("country_name"));
                result.add(country);
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
    public void save(Country country) {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        String query = "INSERT INTO Country(id,country_name) " +
                "values(?, ?);";


        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(query);
            stmt.setInt(1,country.getId());
            stmt.setString(2,country.getCountryName());
            stmt.executeUpdate();
            connection.commit();
            System.out.println("Save " + country);
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
            factory.closeQuietly(stmt);
            factory.closeQuietly(connection);
        }
        factory.closeConnection(connection);
    }
}
