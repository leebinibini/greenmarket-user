package live.greenmarket.user.model.repository;

import live.greenmarket.user.model.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
}
