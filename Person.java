package com.hotelprogram;
import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String surname;
    private String creditCardNumber;

    public Person(String firstName, String surname, String creditCardNumber) {
        this.firstName = firstName;
        this.surname = surname;
        this.creditCardNumber = creditCardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }
}
