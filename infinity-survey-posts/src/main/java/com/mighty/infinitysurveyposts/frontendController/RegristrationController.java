package com.mighty.infinitysurveyposts.frontendController;

import com.mighty.infinitysurveyposts.models.UserModel;
import com.mighty.infinitysurveyposts.services.RegristrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin (origins = "http://127.0.0.1:5500")
@RestController
public class RegristrationController {

    @Autowired
    RegristrationService regristrationService = new RegristrationService();
    @PostMapping("/regristration")
    public ResponseEntity<String> infiniservDataController(@RequestBody UserModel user){ //was macht dieser code (@RequestBody UserModel user)

    return regristrationService.createUser(user);

    }

}

