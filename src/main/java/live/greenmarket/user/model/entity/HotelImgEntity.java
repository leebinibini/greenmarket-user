package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@Setter
@Getter
@Table(name="hotelImgs")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HotelImgEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String filepath;
    private String filename;
    private int hotelId;

}
