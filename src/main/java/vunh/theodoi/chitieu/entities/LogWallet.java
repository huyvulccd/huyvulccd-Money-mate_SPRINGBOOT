package vunh.theodoi.chitieu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogWallet{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeStamp;

    @Column(nullable = false)
    private String idUser;

    @Column(nullable = false)
    private Long idWallet;

    @Column(nullable = false)
    private long amount;

    @Column(nullable = false)
    private String action;

    private String memo;
}
