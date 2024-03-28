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
    private int added =0;


    protected static final Logger logger = LogManager.getLogger();



    public ResponseEntity<String> extractOpinionData (Map<String, Object> opinionData){
        System.out.println("post Data Service: " + opinionData);
        try {
            int opinion_Length = (int) opinionData.get("opinionlength");
            for (int i = 0; i < opinion_Length; i++) {
                Map<String, Object> answerBox_0 = (Map<String, Object>) opinionData.get("answerBox_" + i);
                String opinionValue = (String) answerBox_0.get("value");
                int order_Id = (int) answerBox_0.get("id");
                int votes = (int) answerBox_0.get("votes");



                OpinionModel opinionModel = new OpinionModel();




                opinionModel.setOpinion(opinionValue);
                opinionModel.setOpinion_order_id(order_Id);
                opinionModel.setOpinionlength(opinion_Length);
                opinionModel.setVotes(votes);

                System.out.println(opinionModel.getOpinion());
                System.out.println(opinionModel.getOpinion_order_id());
                System.out.println(opinionModel.getVotes());
                System.out.println("saved: " + added);


               opinionRepository.save(opinionModel);

            }
        } catch (Exception e) {
            logger.error("OpinionDataService: "+ e);
            throw new RuntimeException(e);

        }
        return new ResponseEntity<>("post savings didnt work",HttpStatus.OK);
    }



}