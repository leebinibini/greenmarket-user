package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Table(name="reviews")
@Data
@Entity
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reservationId")
    private int reservationId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "rating")
    private float rating;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

    @Column(name = "memberId")
    private int memberId;

    @Column(name = "memberName")
    private String memberName;

    //
    // 보드에는
    //@OneToMany (mappedBy: 보드에 있는 리뷰들이 딸려온다. 위의가 보드즈면 아래는 단수인 보드여야 한다.)

    //리뷰에는 자식이 많으니까 private BoardEntity board; @ManyToOne @JoinColum(name= "board_id")
}
