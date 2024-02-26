package com.mighty.infinitysurveyposts.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tuser")
public class UserModel {


@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    private Integer user_id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    private String email;

    private int age;

    private Date birthday;

    private String country;

    private Date lastlogin = new Date();
    private Date created_At = new Date();

    public void User(String firstname, String lastname, String username,String password, String email, int age, Date birthday  , String country, Date lastlogin, Date created_At){
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
        this.birthday = birthday;
        this.country = country;
        this.lastlogin = lastlogin;
        this.created_At = created_At;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public void String(String password) {
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

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_at) {
        this.created_At = created_At;
    }

}
