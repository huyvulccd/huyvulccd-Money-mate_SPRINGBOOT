package vunh.theodoi.chitieu.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private Long id;
    private String name;
    private String[] subCategories;
    private byte order;
    private String color;
    private boolean isTracking;
}
