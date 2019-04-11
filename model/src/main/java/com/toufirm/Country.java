package com.toufirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * Created by Illia Chenchak
 */
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Country {

    private Long id;

    private String countryName;

    public Country(Long id, String countryName) {
        this.id = id;
        this.countryName = countryName;
    }
}
