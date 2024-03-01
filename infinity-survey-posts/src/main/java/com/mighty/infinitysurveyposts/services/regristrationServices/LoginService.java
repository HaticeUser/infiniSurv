package com.mighty.infinitysurveyposts.services.regristrationServices;

import com.mighty.infinitysurveyposts.models.UserModel;
import com.mighty.infinitysurveyposts.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;
    private boolean status;

    public ResponseEntity<Boolean> loginAuthentification (UserModel user){

        UserModel userEmail = userRepository.findByEmail(user.getEmail());

        if(userEmail != null){
            if(user.getPassword().equals(userEmail.getPassword())){
                status = true;
            }else {
                status = false;
            }
        }else{
            status =  false;
        }

        return  new ResponseEntity<Boolean>(status,HttpStatus.OK);


    }


}
