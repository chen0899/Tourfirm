package com.tourfirm.impl;

import com.toufirm.City;
import com.tourfirm.CityDAO;
import com.tourfirm.MySQLDAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CityDAOImpl implements CityDAO {


    @Override
    public City getCityById(Integer id) {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        City result = null;
        CountryDAOImpl cD = new CountryDAOImpl();
        String query = "SELECT * from city where  id =" + id + ";";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
            result = new City();
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setCityName(resultSet.getString("city_name"));
                city.setCountry(cD.getCountryById(resultSet.getInt("id_country")));
                result = city;
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
    public List<City> findAll() {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        List<City> result = null;
        CountryDAOImpl c = new CountryDAOImpl();

        String query = "SELECT * FROM City order by City.city_name;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
            result = new ArrayList<>();
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setCityName(resultSet.getString("city_name"));
                city.setCountry(c.getCountryById(resultSet.getInt("id_country")));
                result.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            // factory.closeQuietly(stmt);
            // factory.closeQuietly(connection);
        }
        factory.closeConnection(connection);
        return result;
    }


    @Override
    public void save(City city) {
        PreparedStatement stmt = null;


        String query = "INSERT INTO City(city_name,id_country) " +
                "values( ?,?);";


        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(query);
            stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, city.getCityName());
            stmt.setInt(2, city.getCountry().getId());
            stmt.executeUpdate();
            connection.commit();
            System.out.println("Save " + city);
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

    @Override
    public void update(Integer id, City city) {
        PreparedStatement stmt = null;
        final char dm = (char) 34;

        String query = "UPDATE city SET city_name = " + dm + city.getCityName() + dm +
                " ,id_country  = " + city.getCountry().getId() + " WHERE id =" + id + ";";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
            connection.commit();
            System.out.println("Update City where id= " + id);
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
            factory.rollbackQuietlyConn(connection);

        } finally {
            factory.closePreparedStatement(stmt);
            factory.closeConnection(connection);
        }
        factory.closeConnection(connection);
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement stmt = null;

        String query = "DELETE FROM City WHERE city.id = " + id + " ;";


        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
            connection.commit();
            System.out.println("Delete city where id=" + id);
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
            factory.rollbackQuietlyConn(connection);

        } finally {
            factory.closePreparedStatement(stmt);
            factory.closeConnection(connection);
        }
        factory.closeConnection(connection);
    }
}
