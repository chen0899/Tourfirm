package com.tourfirm.impl;

import com.toufirm.Client;
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

        String query = "SELECT * FROM COUNTRY where Country.id ="+id+" order by Country.country_name;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
            result = new Country();
            while (resultSet.next()) {
                Country country= new Country();
                country.setId(resultSet.getLong("id"));
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
                Country country= new Country();
                country.setId(resultSet.getLong("id"));
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
}
