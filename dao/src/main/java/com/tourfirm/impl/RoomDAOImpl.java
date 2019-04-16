package com.tourfirm.impl;

import com.toufirm.Hotel;
import com.toufirm.Room;
import com.toufirm.RoomType;
import com.tourfirm.MySQLDAOFactory;
import com.tourfirm.RoomDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public Room findById(Long id) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        Room room = new Room();

        String query = "SELECT room.id, room_number, count_places, hotel.hotel_name, roomtype.type FROM room "
                + "inner join roomtype on roomtype.id = room.id_room_type "
                + "inner join hotel on hotel.id = room.id_hotel "
                + "WHERE room.id = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Hotel hotel = new Hotel();
                RoomType roomType = new RoomType();
                hotel.setHotelName(resultSet.getString("hotel_name"));
                roomType.setType(resultSet.getString("type"));
                room.setId(resultSet.getLong("id"));
                room.setRoomNumber(resultSet.getLong("room_number"));
                room.setNumberOfPlaces(resultSet.getInt("count_places"));
                room.setHotel(hotel);
                room.setRoomType(roomType);
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(preparedStatement);
            factory.closeConnection(connection);
        }
        return room;
    }

    public List<Room> findAllByHotelName(String hotelName) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        List<Room> result = null;

        String query = "SELECT room.id, room_number, count_places, hotel.hotel_name, roomtype.type FROM room "
                + "inner join roomtype on roomtype.id = room.id_room_type "
                + "inner join hotel on hotel.id = room.id_hotel "
                + "WHERE hotel.hotel_name = ? "
                + "ORDER BY id ASC;";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, hotelName);
            resultSet = preparedStatement.executeQuery();
            result = new ArrayList<>();
            while (resultSet.next()) {
                Room room = new Room();
                Hotel hotel = new Hotel();
                RoomType roomType = new RoomType();
                hotel.setHotelName(resultSet.getString("hotel_name"));
                roomType.setType(resultSet.getString("type"));
                room.setId(resultSet.getLong("id"));
                room.setRoomNumber(resultSet.getLong("room_number"));
                room.setNumberOfPlaces(resultSet.getInt("count_places"));
                room.setHotel(hotel);
                room.setRoomType(roomType);
                result.add(room);
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(preparedStatement);
            factory.closeConnection(connection);
        }
        return result;
    }

    @Override
    public void save(Room room) {
        PreparedStatement preparedStatement = null;

        String query = "INSERT INTO room (room_number, count_places, id_hotel, id_room_type) " +
                "VALUES ( ?, ?, ?, ?);";
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, room.getRoomNumber());
            preparedStatement.setLong(2, room.getNumberOfPlaces());
            preparedStatement.setLong(3, room.getHotel().getId());
            preparedStatement.setLong(4, room.getRoomType().getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            factory.rollbackQuietlyConn(connection);
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(preparedStatement);
            factory.closeConnection(connection);
        }
    }

    @Override
    public void update(Room room) {
        PreparedStatement preparedStatement = null;
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        String query = "UPDATE room SET room_number =?, count_places = ?, id_hotel=?, id_room_type=?  WHERE id=?;";

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, room.getRoomNumber());
            preparedStatement.setLong(2, room.getNumberOfPlaces());
            preparedStatement.setLong(3, room.getHotel().getId());
            preparedStatement.setLong(4, room.getRoomType().getId());
            preparedStatement.setLong(5, room.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            factory.rollbackQuietlyConn(connection);
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(preparedStatement);
            factory.closeConnection(connection);
        }
    }

    @Override
    public void delete(Room room) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        PreparedStatement preparedStatement = null;

        String query = "DELETE FROM room WHERE id=?;";

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
            factory.closeConnection(connection);
        }
    }
}
