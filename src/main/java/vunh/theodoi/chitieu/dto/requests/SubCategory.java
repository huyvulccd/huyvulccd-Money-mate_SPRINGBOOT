package vunh.theodoi.chitieu.dto.requests;

public record SubCategory (
        String name,
        boolean isTracking,
        int sortOrder
) {
}
