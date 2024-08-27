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
public class PriceModel {
    private Long id;
    private int price;
    private int surcharge;
}
