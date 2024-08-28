package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name="searchResults")
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double rating;
    private int price;
    private int roomId;
    private boolean swimmingPool;
    private boolean parking;
    private boolean smoking;
    private boolean restaurant;
    private boolean laundryFacilities;
    private boolean fitnessCenter;
}
