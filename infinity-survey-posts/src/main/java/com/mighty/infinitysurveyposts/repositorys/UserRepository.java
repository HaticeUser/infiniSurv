package com.mighty.infinitysurveyposts.repositorys;
import com.mighty.infinitysurveyposts.models.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer>{
    UserModel findByEmail (String email);
}


