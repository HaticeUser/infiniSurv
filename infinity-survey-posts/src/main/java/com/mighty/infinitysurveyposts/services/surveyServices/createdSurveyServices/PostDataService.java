package com.mighty.infinitysurveyposts.services.surveyServices.createdSurveyServices;


import com.mighty.infinitysurveyposts.models.survey.PostModel;
import com.mighty.infinitysurveyposts.repositorys.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Slf4j
@Service
public class PostDataService {

    @Autowired
    PostRepository postRepository;
    // @Autowired
    //OpinionDataService opinionDataService = new OpinionDataService();
    public ResponseEntity<PostModel> addCreatedSurveyData (PostModel survey){

        try {
            survey.setQuestion(survey.getQuestion());
            survey.setLikes(survey.getLikes());
            survey.setSavings(survey.getSavings());
            survey.setLikes_disabled(survey.getLikes_disabled());
            survey.setUser_storings_disabled(survey.getUser_storings_disabled());
            survey.setObject_ID(survey.getObject_ID());

            lastSurveyDataAssignment(survey);

            postRepository.save(survey);
           // opinionDataService.addRelationalData(survey);
            return new ResponseEntity<>(survey, HttpStatus.OK);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void lastSurveyDataAssignment (PostModel survey){
        Date currentDate = new Date();
        survey.setCreated_At(currentDate);

        // beides hier ??
        survey.setObject_ID(1);
    }

}

