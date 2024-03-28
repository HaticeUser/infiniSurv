package com.mighty.infinitysurveyposts.services.surveyServices.createdSurveyServices;


import com.mighty.infinitysurveyposts.models.survey.OpinionModel;
import com.mighty.infinitysurveyposts.models.survey.PostModel;
import com.mighty.infinitysurveyposts.repositorys.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    @Autowired
    OpinionDataService opinionDataService;
    protected static final Logger logger = LogManager.getLogger();


    public ResponseEntity<?> extractPostData (Map<String, Object> postData){
        System.out.println("post Data Service: " + postData);
        try {
            PostModel postModel = new PostModel();
            postModel.setQuestion((String) postData.get("question"));
            postModel.setLikes((int) postData.get("likes"));
            postModel.setLikes_disabled((boolean) postData.get("likes_disabled"));
            postModel.setSavings((int) postData.get("user_storings"));
            postModel.setUser_storings_disabled((boolean) postData.get("user_storings_disabled") );

            System.out.println(postModel.getQuestion());
            System.out.println(postModel.getLikes());
            System.out.println(postModel.getLikes_disabled());
            System.out.println(postModel.getSavings());
            System.out.println(postModel.getUser_storings_disabled());



            lastSurveyDataAssignment(postModel);

            System.out.println("post_id: " + postModel.getPost_id());



            PostModel geModel = postRepository.save(postModel);
            System.out.println(geModel.getPost_id());
            //opinionDataService.forwardingPostID();
            return new ResponseEntity<>(postModel, HttpStatus.OK);


        } catch (Exception e) {
            logger.error("PostDataService: "+ e);
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
