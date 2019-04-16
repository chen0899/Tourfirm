package com.tourfirm.impl;

import com.toufirm.City;
import com.toufirm.Hotel;
import com.tourfirm.HotelDAO;
import com.tourfirm.MySQLDAOFactory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOImpl implements HotelDAO {
    @Override
    public Hotel findHotelByName(String hotelName) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        Hotel hotel = new Hotel();

        String query = "SELECT hotel.id, hotel_name, e_mail, phone, city.city_name, adress FROM hotel "
                + "INNER JOIN city on city.id= hotel.id_city "
                + "WHERE hotel_name = ? ";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, hotelName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                City city = new City();
                hotel.setId(resultSet.getLong("id"));
                hotel.setHotelName(resultSet.getString("hotel_name"));
                hotel.setEmail(resultSet.getString("e_mail"));
                hotel.setPhone(resultSet.getString("phone"));
                city.setCityName(resultSet.getString("city_name"));
                hotel.setCity(city);
                hotel.setAddress(resultSet.getString("adress"));
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(preparedStatement);
        }
        return hotel;
    }

    @Override
    public List<Hotel> findAllByCity(String cityName) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        List<Hotel> result = null;

        String query = "SELECT id, hotel_name, e_mail, phone, city.city_name, adress FROM hotel "
                + "INNER JOIN city on city.id= hotel.id_city "
                + "WHERE city.city_name = ? ";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cityName);
            resultSet = preparedStatement.executeQuery();
            result = new ArrayList<>();
            while (resultSet.next()) {
                Hotel hotel = new Hotel();
                City city = new City();
                city.setCityName(resultSet.getString("city_name"));
                hotel.setId(resultSet.getLong("id"));
                hotel.setHotelName(resultSet.getString("hotel_name"));
                hotel.setEmail(resultSet.getString("e_mail"));
                hotel.setPhone(resultSet.getString("phone"));
                hotel.setCity(city);
                hotel.setAddress(resultSet.getString("adress"));
                result.add(hotel);
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(preparedStatement);
        }
        return result;
    }

    @Override
    public void save(Hotel hotel) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        PreparedStatement preparedStatement = null;

        String query = "INSERT INTO hotel (hotel_name, e_mail, phone, id_city, adress) "
                + "VALUES (?,?,?,?,?);";

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, hotel.getHotelName());
            preparedStatement.setString(2, hotel.getEmail());
            preparedStatement.setString(3, hotel.getPhone());
            preparedStatement.setLong(4, hotel.getCity().getId());
            preparedStatement.setString(5, hotel.getAddress());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            factory.rollbackQuietlyConn(connection);
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void update(Hotel hotel) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        PreparedStatement preparedStatement = null;

        String query = "UPDATE  hotel SET hotel_name=?, e_mail=?, phone=?, id_city=?, adress=? "
                + "WHERE id = ?;";

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, hotel.getHotelName());
            preparedStatement.setString(2, hotel.getEmail());
            preparedStatement.setString(3, hotel.getPhone());
            preparedStatement.setLong(4, hotel.getCity().getId());
            preparedStatement.setString(5, hotel.getAddress());
            preparedStatement.setLong(6, hotel.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            factory.rollbackQuietlyConn(connection);
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void delete(Hotel hotel) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        PreparedStatement preparedStatement = null;

        String query = "DELETE FROM hotel WHERE id=?;";

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, hotel.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            factory.rollbackQuietlyConn(connection);
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(preparedStatement);
        }
    }
}
