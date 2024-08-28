package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name="roomImgs")
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomImgEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String filepath;
    private String filename;
    private int roomId;
}
