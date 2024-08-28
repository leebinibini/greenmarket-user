package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name="synthesiss")
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SynthesisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int limitPeople;
    private String type;
    private int hotelId;
    private int roomId;
    private boolean bath;
    private int bed;
    private String view;
    private int price;
    private int surcharge;
    private String content;
}
