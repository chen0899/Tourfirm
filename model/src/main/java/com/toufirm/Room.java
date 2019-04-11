package com.toufirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Setter
@Getter
public class Room {
    private Long id;
    private Long roomNumber;
    private int numberOfPlaces;
    private String nameHotel;
    private String roomType;
}
