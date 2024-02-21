package com.mighty.infinitysurveyposts.service;

import com.mighty.infinitysurveyposts.User.User;

import java.util.Date;

public class InfiniService {

    public String mapUser(User request){
        String firstname = request.getFirstname();
        String lastname = request.getLastname();
        int age = request.getAge();
        String username = request.getUsername();
        Date birthday = request.getBirthday();
        char[] passwordField = request.getPassword().getPassword();
        String passText = new String(passwordField);

        System.out.println("Alle Daten: " + firstname + " " + lastname + " " + age  + " " + passwordField + " String Text: " + passText );

    }
}
