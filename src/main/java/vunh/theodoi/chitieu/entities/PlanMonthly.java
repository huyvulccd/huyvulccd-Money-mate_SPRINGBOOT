package vunh.theodoi.chitieu.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanMonthly {
    @EmbeddedId
    private PlanMonthlyId id;

    @Column(nullable = false)
    private String idUser;

    @Column(nullable = false)
    private String subCategory;

    @Column(nullable = false)
    private long budget;

    private String message;
}
