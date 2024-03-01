package com.mighty.infinitysurveyposts.services.regristrationServices;


import com.mighty.infinitysurveyposts.repositorys.UserRepository;
import com.mighty.infinitysurveyposts.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SignUpService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> createUser(UserModel user) {
        user.setFirstname(user.getFirstname());
        user.setLastname(user.getLastname());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        user.setAge(user.getAge());
        user.setBirthday(user.getBirthday());
        user.setCountry(user.getCountry());
        user.setGender(user.getGender());
        user.setLast_login(user.getLast_login());
        user.setCreated_At(user.getCreated_At());

        lastUserDataAssignment(user);
        userRepository.save(user);
        return new ResponseEntity<String>("User Saved", HttpStatus.OK) ;
    }

    public void lastUserDataAssignment (UserModel user){
        Date currentDate = new Date();
        user.setCreated_At(currentDate);
        user.setLast_login(currentDate);
    }
}

