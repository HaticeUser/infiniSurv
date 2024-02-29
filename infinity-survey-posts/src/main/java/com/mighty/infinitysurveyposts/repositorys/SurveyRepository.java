package com.mighty.infinitysurveyposts.repositorys;


import com.mighty.infinitysurveyposts.models.SurveyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


public interface SurveyRepository extends JpaRepository<SurveyModel,Integer> {


}
