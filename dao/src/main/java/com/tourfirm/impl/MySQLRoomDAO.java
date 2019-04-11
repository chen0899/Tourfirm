package com.tourfirm.impl;

import com.toufirm.Room;
import com.tourfirm.MySQLDAOFactory;
import com.tourfirm.RoomDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLRoomDAO implements RoomDAO {

    public Room getRoomById(int id) {
        return null;
    }

    public List<Room> findAll() {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        List<Room> result = null;

        String query = "SELECT room.id, room_number, count_places, hotel.hotel_name, roomtype.type  FROM room " +
                "inner join roomtype on roomtype.id = room.id_room_type " +
                "inner join hotel on hotel.id = room.id_hotel " +
                "ORDER BY hotel.hotel_name ASC;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
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
            factory.closeQuietly(stmt);
            factory.closeQuietly(connection);
        }
        factory.closeConnection(connection);
        return result;
    }
}
