package com.mighty.infinitysurveyposts.services;


import com.mighty.infinitysurveyposts.Repositorys.UserRepository;
import com.mighty.infinitysurveyposts.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegristrationService {

    @Autowired
    private UserRepository userRepository;
    public ResponseEntity<String>  createUser(UserModel user) { // was macht dieser code ?? (UserModel user) ??

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

        lastUserDataAssignment(user);
        userRepository.save(user);

        System.out.println( "Alle Daten: Firstname " + firstname +
                " Lastname: " + lastname + " Username: " + username
                + " birthday: " + birthday + "  age: " + age +
                " password: " + password + "email: " + email +
                " country: " + country + "lastLogin: " + lastLogin);



        return new ResponseEntity<String>("User Saved", HttpStatus.OK) ;
    }

    public void lastUserDataAssignment (UserModel user){
        Date currentDate = new Date();
        user.setCreated_At(currentDate);
        user.setLastlogin(currentDate);
    }
}

