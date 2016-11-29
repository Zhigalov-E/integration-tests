package com.myorg.gwt.entities;


import java.util.Date;

public class UserRow {
    private String firstName;
    private String lastName;
    private Date birthday;
    private String email;

    public UserRow(String firstName, String lastName, Date birthday, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserRow{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRow userRow = (UserRow) o;

        if (firstName != null ? !firstName.equals(userRow.firstName) : userRow.firstName != null) return false;
        if (lastName != null ? !lastName.equals(userRow.lastName) : userRow.lastName != null) return false;
        if (birthday != null ? !birthday.equals(userRow.birthday) : userRow.birthday != null) return false;
        return email != null ? email.equals(userRow.email) : userRow.email == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
