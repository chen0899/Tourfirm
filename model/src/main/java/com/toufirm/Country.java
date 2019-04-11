package com.toufirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * Created by Illia Chenchak
 */

@Getter
@Setter
@ToString
public class Country {

    private Long id;

    private String countryName;

    public Country() {

    }

    public Country(Long id, String countryName) {
        this.id = id;
        this.countryName = countryName;
    }
}
