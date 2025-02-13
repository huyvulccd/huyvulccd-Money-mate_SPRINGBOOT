package vunh.theodoi.chitieu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {

    @EmbeddedId
    private WalletId id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long balance;
    @Column(nullable = false)
    private boolean isSavingWallet;
    @Column(nullable = false)
    private String idUser;

}
