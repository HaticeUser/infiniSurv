package com.mighty.infinitysurveyposts.Repositorys;
import com.mighty.infinitysurveyposts.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel,Integer>{

}
