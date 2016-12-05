package com.myorg.gwt.entities;


public class UserRow {
    private String firstName;
    private String lastName;
    private String birthDay;
    private String email;

    public UserRow(String firstName, String lastName, String birthDay, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
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
                ", birthDay='" + birthDay + '\'' +
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
        if (birthDay != null ? !birthDay.equals(userRow.birthDay) : userRow.birthDay != null) return false;
        return email != null ? email.equals(userRow.email) : userRow.email == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
