package com.mighty.infinitysurveyposts.frontendController;

import com.mighty.infinitysurveyposts.User.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.Date;

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

    @PostMapping ("/createuser")
    public String infiniservDataController(@RequestBody User request){
       String firstname = request.getFirstname();
       String lastname = request.getLastname();
       int age = request.getAge();
       String username = request.getUsername();
       Date birthday = request.getBirthday();
       char[] passwordField = request.getPassword().getPassword();
       String passText = new String(passwordField);

        System.out.println("Alle Daten: " + firstname + " " + lastname + " " + age  + " " + passwordField + " String Text: " + passText );

       return "Daten wurden erfolgreich angenommen und in der Datenbank gespeichert";
    }


}
