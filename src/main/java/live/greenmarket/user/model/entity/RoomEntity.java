package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name="rooms")
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int limitPeople;
    private String type;
    private int hotelId;
}
