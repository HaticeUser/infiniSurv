package com.mighty.infinitysurveyposts.frontendController;


import com.mighty.infinitysurveyposts.models.SurveyModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class SurveyController {

    @PostMapping("/surveycreation")
    public ResponseEntity<String> surveyCreationController(@RequestBody SurveyModel survey){


        return new ResponseEntity<String>("Data saved", HttpStatus.OK);//noch mitn  Service ändern

    }

}
