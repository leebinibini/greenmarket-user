package live.greenmarket.user.service.impl;

import live.greenmarket.user.model.entity.PriceEntity;
import live.greenmarket.user.model.entity.ReviewEntity;
import live.greenmarket.user.model.repository.ReviewRepository;
import live.greenmarket.user.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;


    @Override
    public List<ReviewEntity> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<ReviewEntity> findById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return reviewRepository.existsById(id);
    }

    @Override
    public long count() {
        return reviewRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}
