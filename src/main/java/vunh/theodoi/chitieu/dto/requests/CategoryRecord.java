package vunh.theodoi.chitieu.dto.requests;

import java.util.List;

public record CategoryRecord(
        Long id,
        String name,
        Byte order,
        Boolean isTracking,
        String color,
        String subCategories
) {
}
