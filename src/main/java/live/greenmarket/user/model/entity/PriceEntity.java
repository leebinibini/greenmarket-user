package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="prices")
@Entity
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "price")
    private int price;

    @Column(name = "surcharge")
    private int surcharge;
}
