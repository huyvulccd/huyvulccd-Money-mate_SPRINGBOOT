package vunh.theodoi.chitieu.enums;

import lombok.Getter;

@Getter
public enum CategoryType {
    FIXED("Cố định"),
    ESSENTIAL("Thiết yếu"),
    ENTERTAINMENT("Giải trí"),
    OTHER("Khác");

    private final String name;
    CategoryType(String name) {
        this.name = name;
    }   
}
