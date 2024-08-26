package live.greenmarket.user.model.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

//@Builder
@Data
@Component
public class HotelModel {
    private Long id;
    private int memberId;
    private String name;
    private String tel;
    private float rating;
    private String content;

    private String providerName;
}
