package vunh.theodoi.chitieu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vunh.theodoi.chitieu.entities.Transaction;
import vunh.theodoi.chitieu.entities.TransactionId;

public interface TransactionRepository extends JpaRepository<Transaction, TransactionId> {

    @Query(value = "SELECT COUNT(t) FROM Transaction t WHERE t.id_user = :idUser AND t.month = :month", nativeQuery = true)
    Long countTransactionsInMonth(String monthId, String username);
}
