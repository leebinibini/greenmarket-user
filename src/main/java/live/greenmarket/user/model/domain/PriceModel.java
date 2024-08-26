package live.greenmarket.user.model.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
//@Builder
@Data
@Component
public class PriceModel {
    private int id;
    private int price;
    private int surcharge;
}
