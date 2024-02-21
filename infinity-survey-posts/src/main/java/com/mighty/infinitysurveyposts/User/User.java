package com.mighty.infinitysurveyposts.User;

import javax.swing.*;
import java.util.Date;

public class User {
    private String firstname;
    private String lastname;
    private String username;


    private JPasswordField passwordField = new JPasswordField();

    private String email;

    private int age;

    private Date birthday; //unsafe??

    private String country;

    private Date lastlogin = new Date(); //unsafe ??
    private Date created_at = new Date(); // unsafe ??
                                                                                                 //unsafe??
    public void User(String firstname, String lastname, String username,JPasswordField passwordField, String email, int age, Date birthday  , String country, Date lastlogin, Date created_at){
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.passwordField = passwordField;
        this.age = age;
        this.email = email;
        this.birthday = birthday;
        this.country = country;
        this.lastlogin = lastlogin;
        this.created_at = created_at;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public JPasswordField getPassword() {
        return passwordField;
    }

    public void JPasswordField(int password) {
        this.passwordField = passwordField;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

}
