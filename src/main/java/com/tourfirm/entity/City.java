package com.tourfirm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "city_name")
    @NotNull
    @Size(min=2, max=30)
    private String cityName;
    @ManyToOne
    @JoinColumn(name = "id_country", referencedColumnName = "id")
    private Country country;

}
