package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@Setter
@Getter
@Table(name="locations")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;
    private String address;
    private String sido;
    private String sigungu;
    private String zonecode;
    private String buildingName;
}
