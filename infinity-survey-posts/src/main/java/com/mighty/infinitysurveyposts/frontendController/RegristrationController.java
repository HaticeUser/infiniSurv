package com.mighty.infinitysurveyposts.frontendController;

import com.mighty.infinitysurveyposts.models.UserModel;
import com.mighty.infinitysurveyposts.services.RegristrationService;
import org.springframework.web.bind.annotation.*;

//@RequestParam(value = "firstname")String firstname, @RequestParam(value = "lastname")String lastname
// if(firstname.equals("admin")){
//           return new ResponseEntity<String>("Hello " + firstname +" " + lastname, HttpStatus.OK);
//       }
//
//        return new ResponseEntity<String>("Error, youre not the admin", HttpStatus.BAD_REQUEST);
//    }

//    int password = request.getPassword();
//       int age = request.getAge();

@CrossOrigin (origins = "http://127.0.0.1:5500")
@RestController
public class RegristrationController {

    RegristrationService regristrationService = new RegristrationService();
    @PostMapping("/regristration")
    public String infiniservDataController(@RequestBody UserModel user){ //was macht dieser code (@RequestBody UserModel user)
    return regristrationService.createUser(user);

    }

}

