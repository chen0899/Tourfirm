package com.tourfirm.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Illia Chenchak
 */
@Entity
@Table(name = "booking")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_room", referencedColumnName = "id")
    private Room room;

}
