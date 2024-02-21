package com.mighty.infinitysurveyposts.frontendController;

import com.mighty.infinitysurveyposts.User.User;
import com.mighty.infinitysurveyposts.service.InfiniService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
public class infiniservController {

    InfiniService infiniService = new InfiniService();

    @PostMapping ("/createuser")
    public String infiniservDataController(@RequestBody User request){
       return infiniService.mapUser(request);
    }

}
