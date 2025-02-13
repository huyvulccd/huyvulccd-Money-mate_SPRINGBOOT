package vunh.theodoi.chitieu.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanMonthlyId {
    private Integer id;
    private Integer categoryId;
}
