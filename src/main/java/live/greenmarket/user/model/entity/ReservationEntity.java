package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Builder
@Setter
@Getter
@Table(name="reservations")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date checkIn;
    private Date checkOut;
    private boolean confirmed;
    private boolean status;
    private int roomId;
    private int memberId;
}
