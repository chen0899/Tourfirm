package com.tourfirm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "room_number")
    private Integer roomNumber;
    @Column(name = "count_places")
    private Integer numberOfPlaces;
    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "id_room_type", referencedColumnName = "id")
    private RoomType roomType;
}
