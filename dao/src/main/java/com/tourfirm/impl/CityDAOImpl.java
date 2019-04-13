package com.tourfirm.impl;


import com.tourfirm.MySQLDAOFactory;
import com.toufirm.City;
import com.tourfirm.CityDAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CityDAOImpl implements CityDAO {


    @Override
    public City getCityById(Integer id) {
        return null;
    }

    @Override
    public List<City> findAll() {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        List<City> result = null;

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
        ResultSet resultSet = null;

        String query = "INSERT INTO City(id,city_name,id_country) " +
                "values(?, ?,?);";


        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(query);
            stmt.setInt(1,city.getId());
            stmt.setString(2,city.getCityName());
            stmt.setInt(3,city.getCountry().getId());
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
           // factory.closeConnection(stmt);
           // factory.closeQuietly(connection);
        }
        factory.closeConnection(connection);
    }
}
