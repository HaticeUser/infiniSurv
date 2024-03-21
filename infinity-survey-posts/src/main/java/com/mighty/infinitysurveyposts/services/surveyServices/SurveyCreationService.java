package com.mighty.infinitysurveyposts.services.surveyServices;


import com.mighty.infinitysurveyposts.models.SurveyModel;
import com.mighty.infinitysurveyposts.repositorys.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Service
public class SurveyCreationService {

    @Autowired
    SurveyRepository surveyRepository;
    public ResponseEntity<SurveyModel> addCreatedSurvey (SurveyModel survey){

        survey.setQuestion(survey.getQuestion());
        survey.setLikes(survey.getLikes());
        survey.setUser_storings(survey.getUser_storings());
        survey.setLikes_disabled(survey.getLikes_disabled());
        survey.setUser_storings_disabled(survey.getUser_storings_disabled());

        survey.setCreated_At(survey.getCreated_At());
        lastUserDataAssignment(survey);

        surveyRepository.save(survey);

        return new ResponseEntity<>(survey, HttpStatus.OK);

    }

    public void lastUserDataAssignment (SurveyModel survey){
        Date currentDate = new Date();
        survey.setCreated_At(currentDate);
    }
}

