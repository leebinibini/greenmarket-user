package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Table(name="searchConditions")
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchConditionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String sido;
    private String sigungu;
    private int people;
    private int rooms;
    private int HotelId;
    private Date checkinDate;
    private Date checkoutDate;
}
