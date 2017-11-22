package main.java.by.epam.web.domain;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private boolean compareFields(User user) {// откуда в бине появился метод логики?
        if (!name.equals(user.name) || !surname.equals(user.surname)
                || !name.equals(user.phoneNumber) || !name.equals(user.email)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 107 * name.hashCode() + surname.hashCode() +
                + phoneNumber.hashCode() + email.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if (!super.equals(user)) {
            return false;
        }
        return compareFields(user);
    }

    @Override
    public String toString() {
        return "name : " + name +
                " surname : " + surname +
                " phone number : " + phoneNumber +
                " e-mail : " + email;
    }
}
