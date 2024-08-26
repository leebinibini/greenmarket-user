package live.greenmarket.user.service;

import live.greenmarket.user.model.domain.UserModel;
import live.greenmarket.user.model.entity.UserEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {

    List<UserEntity> findAll();
    UserEntity  save(UserModel userModel);
    UserEntity findAllById(UserModel id);
    boolean existsById(UserModel id);
    long count();
    void deleteById(UserModel id);



}
