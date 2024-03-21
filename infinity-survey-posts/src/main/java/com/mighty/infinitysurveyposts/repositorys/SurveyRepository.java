package com.mighty.infinitysurveyposts.repositorys;

import com.mighty.infinitysurveyposts.models.SurveyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<SurveyModel,Integer> {


}
