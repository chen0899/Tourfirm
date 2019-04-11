package com.toufirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * Created by Illia Chenchak
 */
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Client {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private Country country;

    public Client(Long id, String firstName, String lastName, String email, String phone, Country country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.country = country;
    }
}
