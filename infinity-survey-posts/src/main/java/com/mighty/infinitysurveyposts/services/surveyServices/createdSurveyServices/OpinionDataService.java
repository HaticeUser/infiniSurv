package com.mighty.infinitysurveyposts.services.surveyServices.createdSurveyServices;

import com.mighty.infinitysurveyposts.models.survey.OpinionModel;
import com.mighty.infinitysurveyposts.repositorys.OpinionRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class OpinionDataService {

    @Autowired
    OpinionRepository opinionRepository;

    OpinionModel opinionModel = new OpinionModel();
    protected static final Logger logger = LogManager.getLogger();
    public ResponseEntity<String> addRelationalData (Map<String, Object> postData){
        System.out.println(postData);
        System.out.println("Hall0");
        try {
            Map<String, Object> answerBox_0 = (Map<String, Object>) postData.get("answerBox_0");
            String value = (String) answerBox_0.get("value");
            int id = (int) answerBox_0.get("id");
            int votes = (int) answerBox_0.get("votes");

            System.out.println("Value: " + value);

            //System.out.println(opinionModel.getOpinionlength());
        } catch (Exception e) {
            logger.error("OpinionDataService: "+ e);
            throw new RuntimeException(e);

        }
        return new ResponseEntity<>("post savings didnt work",HttpStatus.OK);
    }



}