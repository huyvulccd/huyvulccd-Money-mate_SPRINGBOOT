package vunh.theodoi.chitieu.dto.requests;

import java.util.List;

public record CategoryRecord(
        String name,
        List<String> subCategories,
        boolean isTracking,
        boolean isDelete,
        boolean isEdit,
        boolean isCreate
) {
}
