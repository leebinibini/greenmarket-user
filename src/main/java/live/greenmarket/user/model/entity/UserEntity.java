package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;


@Table(name="users")
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

}
