package com.tourfirm;
import com.toufirm.City;

import java.util.List;

/**
 * Created by Illia Chenchak
 */
public interface CityDAO {

    City getCityById(Integer id);

    List<City> findAll();

    void save (City city);

    void update (Integer id, City city);

    void delete (Integer id);

}
