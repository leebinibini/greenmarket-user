package live.greenmarket.user.service;

import live.greenmarket.user.model.domain.PriceModel;
import live.greenmarket.user.model.entity.PriceEntity;

import java.util.List;
import java.util.Optional;


public interface PriceService {
    List<PriceEntity> findAll();
    PriceEntity  save(PriceModel priceModel);
    Optional<PriceEntity> findById(Long id);
    boolean existsById(Long id);
    long count();
    void deleteById(Long id);
}
