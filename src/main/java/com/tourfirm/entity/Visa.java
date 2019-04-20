package com.tourfirm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "visa")
@Getter
@Setter
@NoArgsConstructor
public class Visa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "id_country", referencedColumnName = "id")
    private Country country;
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private Client client;
}