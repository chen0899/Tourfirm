package com.tourfirm.entity;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * Created by Illia Chenchak
 */
@Entity
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "contry_name")
    private String countryName;
}
