package com.toufirm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
public class Visa {
    private Long id;
    private Date startDate;
    private Date endDate;
    private Country country;
    private Client client;

    public Visa(Long id, Date startDate, Date endDate, Country country, Client client) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.country = country;
        this.client = client;
    }
}
