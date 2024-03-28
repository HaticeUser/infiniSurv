package com.mighty.infinitysurveyposts.controller;


import com.mighty.infinitysurveyposts.models.survey.OpinionModel;
import com.mighty.infinitysurveyposts.models.survey.PostModel;
import com.mighty.infinitysurveyposts.services.surveyServices.createdSurveyServices.OpinionDataService;
import com.mighty.infinitysurveyposts.services.surveyServices.createdSurveyServices.PostDataService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class SurveyController {

    @Autowired
    PostDataService postDataService;

    @Autowired
    OpinionDataService opinionDataService;
    protected static final Logger logger = LogManager.getLogger();
    @GetMapping("/surveyposts")
    public ResponseEntity<PostModel> surveyPostsController(@RequestBody PostModel survey){


        return new ResponseEntity<PostModel>(survey, HttpStatus.OK);  // SURVEY FERTIG MACHEN SCHNITTSTELLE VOM ABSENDEN UND ABFANGEN DER DATEN
        //  HIER KOMMT DER RETURN ZUM SERVICE AUFRUF, IM SERVICE DEN REST FERTIG MACHEN/SCHREIBEN.

    }

    @PostMapping("/surveycreation")
    public  ResponseEntity<?>  surveyCreationController(@RequestBody Map<String,Object> postData){
        try {
            postDataService.extractPostData(postData);


            return  opinionDataService.extractOpinionData(postData);   // PostModel
        } catch (Exception e) {
            logger.error("Error in Survey Controller: " + e);
            throw new RuntimeException(e);

    }}





}