package live.greenmarket.user.service;

import live.greenmarket.user.model.domain.HotelModel;
import live.greenmarket.user.model.entity.HotelEntity;
import live.greenmarket.user.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<HotelEntity> findAll();
    Optional<HotelEntity> findById(Long id);
    boolean existsById(Long id);
    long count();
    void deleteById(Long id);
}
