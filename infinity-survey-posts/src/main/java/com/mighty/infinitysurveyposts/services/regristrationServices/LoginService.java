package com.mighty.infinitysurveyposts.services.regristrationServices;

import com.mighty.infinitysurveyposts.models.user.UserModel;
import com.mighty.infinitysurveyposts.repositorys.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;
    private boolean status;
    private static final Logger logger = LogManager.getLogger(LoginService.class);
    public ResponseEntity<Boolean> loginAuthentification (UserModel user){

        UserModel userEmail = userRepository.findByEmail(user.getEmail());

        if(userEmail != null){
            if(user.getPassword().equals(userEmail.getPassword())){
                status = true;
                logger.debug("succesfull User login");
            }else {
                status = false;
            }
        }else{
            status =  false;
            logger.info("Login Failed: No account detected");
        }

        return  new ResponseEntity<Boolean>(status,HttpStatus.OK);


    }


}