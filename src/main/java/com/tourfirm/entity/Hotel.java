package com.tourfirm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name = "e_mail")
    private String email;
    @Column(name = "phone")
    private String phone;
    @ManyToOne
    @JoinColumn(name = "id_city", referencedColumnName = "id")
    private City city;
    @Column(name = "adress")
    private String address;
}
