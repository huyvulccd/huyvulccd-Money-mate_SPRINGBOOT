package vunh.theodoi.chitieu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @EmbeddedId
    private TransactionId id;

    private Integer dayOfMonth;

    @Column(nullable = false)
    private String monthFinance;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private long amount;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String subCategory;

    private String note;
}
