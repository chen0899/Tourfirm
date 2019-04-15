import com.toufirm.City;
import com.toufirm.Client;
import com.toufirm.Hotel;
import com.tourfirm.MySQLDAOFactory;
import com.tourfirm.impl.CountryDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Illia Chenchak
 */
public class BusinessLogic {

    //Select #1
    public List<City> findCityAndCountryInThisFirm() {

        CountryDAOImpl countryDAO = new CountryDAOImpl();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        List<City> result = null;

        String query = "Select * From City;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery(query);
            result = new ArrayList<>();
            while (resultSet.next()) {
                City city= new City();
                city.setId(resultSet.getInt("id"));
                city.setCityName(resultSet.getString("city_name"));
                city.setCountry(countryDAO.getCountryById((int) resultSet.getLong("id_country")));
                result.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(stmt);
            factory.closeConnection(connection);
        }
        factory.closeConnection(connection);
        return result;
    }

    //Select #2
    public List<Hotel> findHotelsByCityName(String cityName) {

        final char dm = (char) 34;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        List<Hotel> result = null;

        String query = "Select * From Hotel inner join City on Hotel.id_city = City.id where City.city_name = " +
                dm + cityName + dm + " ;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();


        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery(query);
            result = new ArrayList<>();
            while (resultSet.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(resultSet.getLong("id"));
                hotel.setHotelName(resultSet.getString("hotel_name"));
                hotel.setEmail(resultSet.getString("e_mail"));
                hotel.setPhone(resultSet.getString("phone"));
                hotel.setCity(null);//todo
                hotel.setAddress(resultSet.getString("adress"));
                result.add(hotel);
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(stmt);
            factory.closeConnection(connection);
        }
        factory.closeConnection(connection);
        return result;

    }

    //Select #5
    public void findCountVisaForClient (Client client) {

        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        List<Client> result = null;

        String query = "Select Clients.id, Clients.firstname, COUNT(Visa.id) From Visa inner join Clients on Visa.id_client = Clients.id WHERE Clients.id = " +
                client.getId() + " ;";

        MySQLDAOFactory factory = new MySQLDAOFactory();
        Connection connection = factory.getConnection();

        try {
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Client: "+ resultSet.getInt("id") + ", " + resultSet.getString("firstname") + " - count of visa = " + resultSet.getInt("COUNT(Visa.id)"));
            }
        } catch (SQLException e) {
            System.out.println("Can't execute SQL = '" + query + "'" + e);
        } finally {
            factory.closePreparedStatement(stmt);
            factory.closeConnection(connection);
        }
        factory.closeConnection(connection);
    }
}
