package com.tourfirm.impl;

import com.toufirm.Room;
import com.tourfirm.MySQLDAOFactory;
import com.tourfirm.RoomDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLRoomDAOImpl implements RoomDAO {

    public Room getRoomById(int id) {
        return null;
    }

    public List<Room> findAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        List<Room> result = null;

        String query = "SELECT room.id, room_number, count_places, hotel.hotel_name, roomtype.type FROM room "
                + "inner join roomtype on roomtype.id = room.id_room_type "
                + "inner join hotel on hotel.id = room.id_hotel "
                + "ORDER BY hotel.hotel_name ASC;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            result = new ArrayList<>();
            while (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getLong("id"));
                room.setRoomNumber(resultSet.getLong("room_number"));
                room.setNumberOfPlaces(resultSet.getInt("count_places"));
                room.setNameHotel(resultSet.getString("hotel_name"));
                room.setRoomType(resultSet.getString("type"));
                result.add(room);
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(preparedStatement);

        }
        return result;
    }

    @Override
    public void save(Room room) {
        PreparedStatement preparedStatement = null;

        String query = "INSERT INTO room ( room_number, count_places, id_hotel, id_room_type) " +
                "VALUES ( ?, ?, ?, ?);";
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, room.getRoomNumber());
            preparedStatement.setLong(2, room.getNumberOfPlaces());
            preparedStatement.setLong(3, 1);
            preparedStatement.setLong(4, 1);
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
    public void update(Room room) {

    }

    @Override
    public void delete(Room room) {
        PreparedStatement preparedStatement = null;

        String query = "DELETE FROM blurb WHERE id=?;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, room.getId());
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
