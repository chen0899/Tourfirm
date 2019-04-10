package com.toufirm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class City {

    private Long id;
    private String cityName;
    private Country country;

    public City(Long id, String cityName, Country country) {
        this.id = id;
        this.cityName = cityName;
        this.country = country;
    }
}
