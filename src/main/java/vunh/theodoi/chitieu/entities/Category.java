package vunh.theodoi.chitieu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String idUser;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String subCategory;

    @Column(nullable = false)
    private boolean isTracking;

    @Column(nullable = false)
    private byte sortOrder;
}
