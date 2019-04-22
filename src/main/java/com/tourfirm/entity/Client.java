package com.tourfirm.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Illia Chenchak
 */
@Entity
@Table(name = "Clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "e_mail")
    private String email;

    @Column(name = "phone")
    private String phone;

    @ManyToOne()
    @JoinColumn(name = "id_country", referencedColumnName = "id")
    private Country country;
}
