package vunh.theodoi.chitieu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vunh.theodoi.chitieu.entities.Wallet;
import vunh.theodoi.chitieu.entities.WalletId;

public interface WalletRepository extends JpaRepository<Wallet, WalletId> {
}
