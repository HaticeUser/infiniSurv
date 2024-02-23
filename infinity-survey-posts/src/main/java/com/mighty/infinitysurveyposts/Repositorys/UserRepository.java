package com.mighty.infinitysurveyposts.Repositorys;
import com.mighty.infinitysurveyposts.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel,Integer>{

}
