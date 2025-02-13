package vunh.theodoi.chitieu.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private String name;
    private String[] subcategories;
    private byte sortOrder;
    boolean isTracking;
}
