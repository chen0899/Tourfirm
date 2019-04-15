package com.tourfirm.impl;

import com.toufirm.Country;
import com.tourfirm.CountryDAO;
import com.tourfirm.MySQLDAOFactory;

import java.sql.*;
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

        String query = "SELECT * FROM country where country.id =" + id + " order by country.country_name;";

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
            factory.closePreparedStatement(stmt);
        }
        return result;
    }

    @Override
    public List<Country> findAll() {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        List<Country> result = null;

        String query = "SELECT * FROM country order by country.id;";

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
            factory.closePreparedStatement(stmt);
        }
        return result;
    }

    @Override
    public void save(Country country) {
        PreparedStatement stmt = null;

        String query = "INSERT INTO country(country_name) " +
                "values(?);";


        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, country.getCountryName());
            stmt.executeUpdate();
            connection.commit();
            System.out.println("Save " + country);
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
            factory.rollbackQuietlyConn(connection);

        } finally {
            factory.closePreparedStatement(stmt);
        }
    }

    @Override
    public void update(Country country) {
        PreparedStatement stmt = null;
        final char dm = (char) 34;

        String query = "UPDATE country " +
                "SET country_name =  "+ dm +country.getCountryName()+dm+
                " WHERE country.id = "+country.getId()+" ;";


        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
            connection.commit();
            System.out.println("Update country where id= " + country.getId());
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
            factory.rollbackQuietlyConn(connection);

        } finally {
            factory.closePreparedStatement(stmt);
        }
    }


    @Override
    public void delete(Integer id) {
        PreparedStatement stmt = null;

        String query = "DELETE FROM country WHERE country.id = "+ id +" ;";


        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
            connection.commit();
            System.out.println("Delete country where id=" + id);
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
            factory.rollbackQuietlyConn(connection);

        } finally {
            factory.closePreparedStatement(stmt);

        }
    }

    @Override
    public Country findByCountryName(String countryName) {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Country result = null;

        String query = "SELECT * FROM country where country.country_name =" + countryName + " order by country.country_name;";

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
            factory.closePreparedStatement(stmt);
        }
        return result;
    }
}
