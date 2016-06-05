package com.mycompany.transferObject;

import java.io.Serializable;

/**
 * Created by iraquil on 31.05.2016.
 */
public final class CustomerDTO implements Serializable {

    private long id;
    private String firstName;
    private String lastName;

    public CustomerDTO() {}

    public CustomerDTO(long id, String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setId(id);
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                getId(), getFirstName(), getLastName());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}