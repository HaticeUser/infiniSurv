package com.mighty.infinitysurveyposts.controller;

import com.mighty.infinitysurveyposts.models.user.UserModel;
import com.mighty.infinitysurveyposts.services.regristrationServices.LoginService;
import com.mighty.infinitysurveyposts.services.regristrationServices.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class RegristrationController {

    @Autowired
    SignUpService signUpService = new SignUpService();

    @Autowired
    LoginService loginService = new LoginService();

    @PostMapping("/login")
    public ResponseEntity<Boolean> loginController(@RequestBody UserModel user){

        return loginService.loginAuthentification(user);

    }
    @PostMapping("/signup")
    public ResponseEntity<String> signUpController(@RequestBody UserModel user){

        return signUpService.createUser(user);

    }

}
