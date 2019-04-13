package com.toufirm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class City {

    private Long id;
    private String cityName;
    private Country country;

    public City() {
    }

    public City(Long id, String cityName, Country country) {
        this.id = id;
        this.cityName = cityName;
        this.country = country;
    }
}
