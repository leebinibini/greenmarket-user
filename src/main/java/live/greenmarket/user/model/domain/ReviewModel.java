package live.greenmarket.user.model.domain;


import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "id")
@Component
public class ReviewModel {
    private Long id;
    private int reservationId;
    private String comment;
    private float rating;
    private Date createdAt;
    private Date updatedAt;
    private int memberId;
    private String memberName;
}
