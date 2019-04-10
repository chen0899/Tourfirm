package com.toufirm;

import lombok.Getter;
import lombok.Setter;


/**
 * Created by Illia Chenchak
 */
public class Client {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String phone;

    @Getter @Setter
    private Country country;

    public Client() {
    }

    public Client(Long id, String firstName, String lastName, String email, String phone, Country country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id) &&
                firstName.equals(client.firstName) &&
                lastName.equals(client.lastName) &&
                email.equals(client.email) &&
                phone.equals(client.phone) &&
                country.equals(client.country);
    }

    @Override
    public String toString() {
        return "com.toufirm.Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", country=" + country +
                '}';
    }
}
