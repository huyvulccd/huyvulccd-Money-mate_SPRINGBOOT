package vunh.theodoi.chitieu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Expense {
    String date;
    String title;
    int amount;
    String type;
    String description;
}
