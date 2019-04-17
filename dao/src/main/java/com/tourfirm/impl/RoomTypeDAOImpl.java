package com.tourfirm.impl;

import com.toufirm.RoomType;
import com.tourfirm.MySQLDAOFactory;
import com.tourfirm.RoomTypeDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDAOImpl implements RoomTypeDAO {

    @Override
    public RoomType findByRoomType(String type) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        RoomType roomType = new RoomType();

        String query = "SELECT id, r.type FROM roomtype r WHERE r.type=? ";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, type);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                roomType.setId(resultSet.getInt("id"));
                roomType.setType(resultSet.getString("type"));
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(preparedStatement);
            factory.closeConnection(connection);
        }
        return roomType;
    }

    @Override
    public List<RoomType> findAll() {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        List<RoomType> result = null;

        String query = "SELECT id, r.type FROM roomtype r "
                + "ORDER BY id ASC;";

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            result = new ArrayList<>();
            while (resultSet.next()) {
                RoomType roomType = new RoomType();
                roomType.setId(resultSet.getInt("id"));
                roomType.setType(resultSet.getString("type"));
                result.add(roomType);
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
    public void save(RoomType roomType) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        PreparedStatement preparedStatement = null;

        String query = "INSERT INTO roomtype (room_type) VALUES (?);";

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, roomType.getType());
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
    public void update(RoomType roomType) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        PreparedStatement preparedStatement = null;

        String query = "UPDATE roomtype SET roomtype.type = ? WHERE id=?;";

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, roomType.getType());
            preparedStatement.setInt(2, roomType.getId());
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
    public void delete(RoomType roomType) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();
        PreparedStatement preparedStatement = null;

        String query = "DELETE FROM roomtype WHERE id=?;";

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, roomType.getId());
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
