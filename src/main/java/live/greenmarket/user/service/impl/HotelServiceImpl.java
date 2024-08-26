package live.greenmarket.user.service.impl;

import live.greenmarket.user.model.domain.HotelModel;
import live.greenmarket.user.model.entity.HotelEntity;
import live.greenmarket.user.model.entity.UserEntity;
import live.greenmarket.user.model.repository.HotelRepository;
import live.greenmarket.user.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    public List<HotelEntity> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public HotelEntity save(HotelModel hotelModel) {
        HotelEntity entity = new HotelEntity();
        return hotelRepository.save(entity);
    }

    @Override
    public Optional<HotelEntity> findById(Long id) {
        return hotelRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return hotelRepository.existsById(id);
    }

    @Override
    public long count() {
        return hotelRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        hotelRepository.deleteById(id);
    }
}
