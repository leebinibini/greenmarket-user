package live.greenmarket.user.service;

import live.greenmarket.user.model.domain.PriceModel;
import live.greenmarket.user.model.entity.PriceEntity;
import live.greenmarket.user.model.entity.ReviewEntity;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<ReviewEntity> findAll();
    Optional<ReviewEntity> findById(Long id);
    boolean existsById(Long id);
    long count();
    void deleteById(Long id);
}
