package live.greenmarket.user.model.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "id")
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
