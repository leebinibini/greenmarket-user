package live.greenmarket.user.model.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component// 타입이다.
public class UserModel {
    private Long id;
    private String username;
    private String password;
}
