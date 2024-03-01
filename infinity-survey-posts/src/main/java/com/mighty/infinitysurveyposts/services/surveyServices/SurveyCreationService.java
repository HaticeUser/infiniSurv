package com.mighty.infinitysurveyposts.services.surveyServices;


import com.mighty.infinitysurveyposts.models.SurveyModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyCreationService {

    public ResponseEntity<SurveyModel> surveyService (SurveyModel survey){


        return new ResponseEntity<SurveyModel>(survey, HttpStatus.OK);

    }
}
