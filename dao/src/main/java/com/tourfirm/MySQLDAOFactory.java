package com.tourfirm;

import com.tourfirm.impl.MySQLRoomDAOImpl;
import com.tourfirm.impl.ClientDAOImpl;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory {

    private static final String RDBMS = "jdbc:mysql://127.0.0.1:3306/tourfirm";

    private static BasicDataSource basicDataSource = new BasicDataSource();

    static {
        basicDataSource.setUrl(RDBMS);
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("1234");
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(10);
        basicDataSource.setMaxOpenPreparedStatements(100);
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = basicDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection closed fail" + e);
        }
    }

    public void closePreparedStatement(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Connection close fail" + e);
            }
        }
    }

    public void closePreparedStatement(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            System.out.println("Prepared statement close fail" + e);
        }
    }

    public void rollbackQuietlyConn(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                System.out.println("Connection rollback fail" + e);
            }
        }
    }

    public HotelDAO getHotelDAO() {
        return null;
    }

    public RoomDAO getRoomDAO() {
        return new MySQLRoomDAOImpl();
    }

    public ClientDAO geClientDAO() {
        return new ClientDAOImpl();
    }

    @Override
    public CountryDAO getCountryDAO() {
        return null;
    }
}
