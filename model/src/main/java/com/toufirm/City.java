package com.toufirm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class City {

    private Integer id;
    private String cityName;
    private Country country;

    public City(){};

    public City(Integer id, String cityName, Country country) {
        this.id = id;
        this.cityName = cityName;
        this.country = country;
    }
}
