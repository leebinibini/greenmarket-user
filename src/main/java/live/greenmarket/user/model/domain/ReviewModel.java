package live.greenmarket.user.model.domain;


import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
//@Builder
public class ReviewModel {
    private int id;
    private int reservationId;
    private String comment;
    private float rating;
    private Date createdAt;
    private Date updatedAt;
    private int memberId;
    private String memberName;
}
