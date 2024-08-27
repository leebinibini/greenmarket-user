package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@Setter
@Getter
@Table(name="hotels")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int memberId;

    private String name;

    private String tel;

    private float rating;

    private String content;

    private String providerName;
}
