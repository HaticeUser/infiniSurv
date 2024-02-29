package com.mighty.infinitysurveyposts.services;

import com.mighty.infinitysurveyposts.models.UserModel;
import com.mighty.infinitysurveyposts.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    public ResponseEntity<String> loginAuthentification (UserModel user){
        String email = user.getEmail();
        String password = user.getPassword();

        System.out.println("Email " + email + "password" + password);

        return new ResponseEntity<String>("Data saved", HttpStatus.OK);

    }


}
