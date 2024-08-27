package live.greenmarket.user.service.impl;

import live.greenmarket.user.model.domain.UserModel;
import live.greenmarket.user.model.entity.UserEntity;
import live.greenmarket.user.model.repository.UserRepository;
import live.greenmarket.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }


    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Map<?, ?> login(Long model) {
        return Map.of();
    }

}
