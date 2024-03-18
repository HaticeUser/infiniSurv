package com.mighty.infinitysurveyposts.services.regristrationServices;


import com.mighty.infinitysurveyposts.repositorys.UserRepository;
import com.mighty.infinitysurveyposts.models.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SignUpService {

    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LogManager.getLogger(SignUpService.class);
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

        UserModel userEmail = userRepository.findByEmail(user.getEmail());


        if(userEmail != null){
            if(!user.getEmail().equals(userEmail.getEmail())){
                lastUserDataAssignment(user);
                userRepository.save(user);
                logger.debug("Added user : {}", () -> user);
                return new ResponseEntity<String>("User Saved", HttpStatus.OK) ;
            }else{
                return new ResponseEntity<String>("Email already exists", HttpStatus.OK) ;
            }

        }else{
            lastUserDataAssignment(user);
            userRepository.save(user);
            logger.debug("Added user : {}", () -> user);
            return new ResponseEntity<String>("User Saved", HttpStatus.OK) ;
        }


    }

    public void lastUserDataAssignment (UserModel user){
        Date currentDate = new Date();
        user.setCreated_At(currentDate);
        user.setLast_login(currentDate);
    }
}