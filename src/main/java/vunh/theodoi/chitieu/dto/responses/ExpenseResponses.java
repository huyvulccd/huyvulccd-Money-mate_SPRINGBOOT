package vunh.theodoi.chitieu.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vunh.theodoi.chitieu.dto.Expense;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponses {
    private List<Expense> expenses;
    private String monthYear;
    private Long total;
}
