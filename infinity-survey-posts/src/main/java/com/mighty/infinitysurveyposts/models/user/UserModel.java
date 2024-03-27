package com.mighty.infinitysurveyposts.models.user;

import com.mighty.infinitysurveyposts.models.survey.OpinionModel;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table( name = "tuser" , schema = "dbuser")
public class UserModel {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer user_id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private int age;
    private Date birthday;
    private String country;
    private String gender;
    private Date last_login = new Date();
    private Date created_At = new Date();

    public UserModel() {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date lastlogin) {
        this.last_login = lastlogin;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

}
