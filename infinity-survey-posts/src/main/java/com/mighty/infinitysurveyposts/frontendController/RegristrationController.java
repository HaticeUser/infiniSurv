package com.mighty.infinitysurveyposts.frontendController;

import com.mighty.infinitysurveyposts.models.UserModel;
import com.mighty.infinitysurveyposts.services.LoginService;
import com.mighty.infinitysurveyposts.services.RegristrationService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin (origins = "http://127.0.0.1:5500")
@RestController
public class RegristrationController {

    @Autowired
    RegristrationService regristrationService = new RegristrationService();

    @Autowired
    LoginService loginService = new LoginService();

    @PostMapping("/login")
    public ResponseEntity<String> loginController(@RequestBody UserModel user){


       return loginService.loginAuthentification(user); // noch mit Service ändern
    }
    @PostMapping("/signup")
    public ResponseEntity<String> signUpController(@RequestBody UserModel user){ //was macht dieser code (@RequestBody UserModel user)

    return regristrationService.createUser(user);

    }

}

