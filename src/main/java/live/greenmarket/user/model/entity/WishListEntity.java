package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Table(name="wishLists")
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WishListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;
    private int memberId;
}
