package com.mighty.infinitysurveyposts.services;


import com.mighty.infinitysurveyposts.models.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegristrationService {


    public String createUser(UserModel user) { // was macht dieser code ?? (UserModel user) ??

        String firstname = user.getFirstname();
        String lastname = user.getLastname();
        int age = user.getAge(); // age wird davor mit dem gegebenen geb. ausgerechnet.
        String username = user.getUsername();
        Date birthday = user.getBirthday();
        String password = user.getPassword();
        String email = user.getEmail();
        String country = user.getCountry();
        Date lastLogin = user.getLastlogin();
        Date createdAt = user.getCreated_At();


        System.out.println( "Alle Daten: Firstname " + firstname +
                " Lastname: " + lastname + " Username: " + username
                + " birthday: " + birthday + "  age: " + age +
                " password: " + password);

        return "Daten wurden erfolgreich zugesendet";

    }

}

