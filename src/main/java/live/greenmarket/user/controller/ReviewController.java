package live.greenmarket.user.controller;

import live.greenmarket.user.model.domain.ReviewModel;
import live.greenmarket.user.model.domain.UserModel;
import live.greenmarket.user.model.entity.ReviewEntity;
import live.greenmarket.user.model.entity.UserEntity;
import live.greenmarket.user.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

//    @PostMapping("/findAll")
    public List<ReviewEntity> findAll() {
        return reviewService.findAll();
    }
//    @PostMapping("/findById")
    public Optional<ReviewEntity> findById(Long id) {
        return reviewService.findById(id);
    }

//    @PostMapping("/existsById")
    public boolean existsById(Long id) {
        return reviewService.existsById(id);
    }

//    @PostMapping("/count")
    public long count() {
        return reviewService.count();
    }

//    @PostMapping("/deleteById")
    public void deleteById(Long id) {
            reviewService.deleteById(id);
    }
}
