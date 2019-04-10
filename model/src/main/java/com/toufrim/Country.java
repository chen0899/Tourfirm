package com.toufrim;

import lombok.Getter;
import lombok.Setter;


/**
 * Created by Illia Chenchak
 */

public class Country {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String countryName;

    public Country() {
    }

    public Country(Long id, String countryName) {
        this.id = id;
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id.equals(country.id) &&
                countryName.equals(country.countryName);
    }

    @Override
    public String toString() {
        return "com.toufrim.Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
