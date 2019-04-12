package com.toufirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * Created by Illia Chenchak
 */
@Getter
@Setter
@ToString
public class Client {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private Country country;

    public Client() {
    }

    public Client(Integer id, String firstName, String lastName, String email, String phone, Country country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.country = country;
    }

}
