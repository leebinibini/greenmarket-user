package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name="reviews")
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int reservationId;
    private String comment;
    private float rating;
    private Date createdAt;
    private Date updatedAt;
    private int memberId;
    private String memberName;

    //
    // 보드에는
    //@OneToMany (mappedBy: 보드에 있는 리뷰들이 딸려온다. 위의가 보드즈면 아래는 단수인 보드여야 한다.)

    //리뷰에는 자식이 많으니까 private BoardEntity board; @ManyToOne @JoinColum(name= "board_id")
}
