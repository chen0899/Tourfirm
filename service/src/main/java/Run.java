import com.toufirm.City;
import com.toufirm.Client;
import com.toufirm.Hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Illia Chenchak
 */
public class Run {
    public static void main(String[] args) {
        BusinessLogic businessLogic = new BusinessLogic();

//        List<Hotel> hotels = businessLogic.findHotelsByCityName("Lviv");
//        hotels.stream().forEach(hotel -> System.out.println(hotel));

//        List<City> cities = businessLogic.findCityAndCountryInThisFirm();
////      cities.stream().forEach(city -> System.out.println(city));

        Client client = new Client();
        client.setId(1);
        businessLogic.findCountVisaForClient(client);
    }
}
