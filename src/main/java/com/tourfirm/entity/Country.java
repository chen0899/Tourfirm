package com.tourfirm.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Illia Chenchak
 */
@Entity
@Data
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "country_name")
    private String countryName;
}
