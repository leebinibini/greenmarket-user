package live.greenmarket.user.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="hotels")
@Entity
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "memberId")
    private int memberId;

    @Column(name = "name")
    private String name;

    @Column(name = "tel")
    private String tel;

    @Column(name = "rating")
    private float rating;

    @Column(name = "content")
    private String content;

    @Column(name = "providerName")
    private String providerName;
}
