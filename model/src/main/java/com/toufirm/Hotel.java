package com.toufirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Hotel {
    private Long id;
    private String hotelName;
    private String email;
    private String phone;
    private City city;
    private String address;
}



