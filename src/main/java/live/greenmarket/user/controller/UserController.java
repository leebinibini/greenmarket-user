package live.greenmarket.user.controller;

import live.greenmarket.user.model.domain.UserModel;
import live.greenmarket.user.model.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {


    public List<UserEntity> findAll() {
        return List.of();
    }

    
    public UserEntity save(UserModel userModel) {
        return null;
    }

    
    public UserEntity findAllById(UserModel id) {
        return null;
    }

    
    public boolean existsById(UserModel id) {
        return false;
    }

    
    public long count() {
        return 0;
    }

    
    public void deleteById(UserModel id) {

    }
}
