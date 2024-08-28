package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@Setter
@Getter
@Table(name="hotelsDescriptions")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HotelDescriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private boolean swimmingPool;
        private boolean parking;
        private boolean restaurant;
        private boolean smoking;
        private boolean laundryFacilities;
        private boolean fitnessCenter;
}
