package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@Setter
@Getter
@Table(name="locationInfos")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LocationInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String sido;
    private String sigungu;
}
