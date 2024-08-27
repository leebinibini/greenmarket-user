package live.greenmarket.user.service;

import live.greenmarket.user.model.domain.UserModel;
import live.greenmarket.user.model.entity.UserEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface UserService {
    List<UserEntity> findAll();
    Optional<UserEntity> findById(Long id);
    boolean existsById(Long id);
    long count();
    void deleteById(Long id);
    Map<?,?> login(Long model);
}
