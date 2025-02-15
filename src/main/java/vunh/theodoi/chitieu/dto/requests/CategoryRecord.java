package vunh.theodoi.chitieu.dto.requests;

public record CategoryRecord(
        Long id,
        String name,
        Byte order,
        Boolean isTracking,
        String color,
        String[] subCategories
) {
}
