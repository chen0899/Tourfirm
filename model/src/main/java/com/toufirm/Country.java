package com.toufirm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Created by Illia Chenchak
 */

@Getter
@Setter
@ToString
public class Country {

    private Integer id;

    private String countryName;

    public Country() {

    }

    public Country(Integer id, String countryName) {
        this.id = id;
        this.countryName = countryName;
    }
}
