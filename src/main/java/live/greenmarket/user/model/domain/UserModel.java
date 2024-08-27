package live.greenmarket.user.model.domain;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "id")
@Component// 타입이다.
public class UserModel {
    private Long id;
    private String username;
    private String password;
}
