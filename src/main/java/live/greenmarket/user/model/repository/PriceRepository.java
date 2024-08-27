package live.greenmarket.user.model.repository;

import live.greenmarket.user.model.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
}
