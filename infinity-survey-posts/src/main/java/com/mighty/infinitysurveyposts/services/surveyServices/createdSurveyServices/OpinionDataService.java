package com.mighty.infinitysurveyposts.services.surveyServices.createdSurveyServices;

import com.mighty.infinitysurveyposts.models.survey.OpinionModel;
import com.mighty.infinitysurveyposts.repositorys.OpinionRepository;
import lombok.extern.slf4j.Slf4j;
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

    public ResponseEntity<String> addRelationalData (Map<String, Object> opinionData){
        try {
            int opinionLength = (int) opinionData.get("opinionlength") ;
            for (int i = 0; i < opinionLength; i++) {
                Map<String, Object> answerBoxData = (Map<String, Object>) opinionData.get("answerBox_" + i);
                String opinionValue =(String) answerBoxData.get("value") ;
                int opinionID = (int) answerBoxData.get("id");
                int votes =(int) answerBoxData.get("votes") ;

                opinionModel.setVotes(votes);
                opinionModel.setOpinion_order_id(opinionID);
                opinionModel.setOpinion(opinionValue);

                opinionRepository.save(opinionModel);
                return new ResponseEntity<>("Answerbox wurde gesetzt", HttpStatus.OK);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>("post savings didnt work",HttpStatus.OK);
    }



}
