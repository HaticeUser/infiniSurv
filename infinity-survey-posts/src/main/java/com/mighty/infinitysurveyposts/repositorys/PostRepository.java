package com.mighty.infinitysurveyposts.repositorys;

import com.mighty.infinitysurveyposts.models.survey.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface PostRepository extends JpaRepository<PostModel,Integer> {






}
