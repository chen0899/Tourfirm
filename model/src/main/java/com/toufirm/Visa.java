package com.toufirm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@ToString
@Getter
@Setter
public class Visa {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private Country country;
    private Client client  ;

    public Visa(){}
    public Visa(Integer id, Date startDate, Date endDate, Country country, Client client) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.country = country;
        this.client = client;
    }
}
