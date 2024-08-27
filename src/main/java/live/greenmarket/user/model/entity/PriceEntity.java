package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@Table(name="prices")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int price;
    private int surcharge;
}
