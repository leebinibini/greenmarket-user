package live.greenmarket.user.controller;

import live.greenmarket.user.model.domain.UserModel;
import live.greenmarket.user.model.entity.UserEntity;
import live.greenmarket.user.model.repository.UserRepository;
import live.greenmarket.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/join")
    public Object join(@RequestBody UserEntity entity){
       return userRepository.save(UserEntity.builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build());
    }

    @PostMapping("/login")
    public Object login(@RequestBody UserModel model){return userService.login(model);
    }
    @PostMapping("/findAll")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @PostMapping("/findById")
    public Optional<UserEntity> findById(Long id) {
        return userService.findById(id);
    }

    @GetMapping("/existsById/{id}")
    public boolean existsById(@PathVariable Long id) {
        return userService.existsById(id);
    }

    
    public long count() {
        return userService.count();
    }

    
    public void deleteById(Long id) {
            userService.deleteById(id);
    }
}
