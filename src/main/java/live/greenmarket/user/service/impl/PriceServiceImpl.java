package live.greenmarket.user.service.impl;

import live.greenmarket.user.model.domain.PriceModel;
import live.greenmarket.user.model.entity.PriceEntity;
import live.greenmarket.user.model.entity.UserEntity;
import live.greenmarket.user.model.repository.PriceRepository;
import live.greenmarket.user.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;

    @Override
    public List<PriceEntity> findAll() {
        return priceRepository.findAll();
    }

    @Override
    public PriceEntity save(PriceModel priceModel) {
        PriceEntity entity = new PriceEntity();
        return priceRepository.save(entity);
    }

    @Override
    public Optional<PriceEntity> findById(Long id) {
        return priceRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return priceRepository.existsById(id);
    }

    @Override
    public long count() {
        return priceRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        priceRepository.deleteById(id);
    }
}
