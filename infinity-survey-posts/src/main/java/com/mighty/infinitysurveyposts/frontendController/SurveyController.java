package com.mighty.infinitysurveyposts.frontendController;


import com.mighty.infinitysurveyposts.models.SurveyModel;
import com.mighty.infinitysurveyposts.services.surveyServices.SurveyCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class SurveyController {

    @Autowired
    SurveyCreationService surveyCreationService = new SurveyCreationService();

    @GetMapping("/surveyposts")
    public ResponseEntity<SurveyModel> surveyPostsController(@RequestBody SurveyModel survey){


        return new ResponseEntity<SurveyModel>(survey, HttpStatus.OK);  // SURVEY FERTIG MACHEN SCHNITTSTELLE VOM ABSENDEN UND ABFANGEN DER DATEN
        //  HIER KOMMT DER RETURN ZUM SERVICE AUFRUF, IM SERVICE DEN REST FERTIG MACHEN/SCHREIBEN.

    }

    @PostMapping("/surveycreation")
    public ResponseEntity<SurveyModel> surveyCreationController(@RequestBody SurveyModel survey){


        return surveyCreationService.addCreatedSurvey(survey);

    }

}