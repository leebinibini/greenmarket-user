package live.greenmarket.user.service.impl;

import live.greenmarket.user.model.domain.UserModel;
import live.greenmarket.user.model.entity.UserEntity;
import live.greenmarket.user.service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {

    @Override
    public List<UserEntity> findAll() {
        return List.of();
    }

    @Override
    public UserEntity save(UserModel userModel) {
        return null;
    }

    @Override
    public UserEntity findAllById(UserModel id) {
        return null;
    }

    @Override
    public boolean existsById(UserModel id) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UserModel id) {

    }
}
