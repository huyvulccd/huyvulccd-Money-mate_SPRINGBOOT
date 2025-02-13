package vunh.theodoi.chitieu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vunh.theodoi.chitieu.dto.responses.CategoryResponse;
import vunh.theodoi.chitieu.entities.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = """
                SELECT EXISTS (
                    SELECT 1
                    FROM category t
                    WHERE t.id_user = :idUser AND CONCAT(t.name, '-', t.sub_category) = :category
                )""", nativeQuery = true)
    int isExists(String idUser, String category);

    List<Category> findByIdUser(String huyvulccd);

    @Query(value = """
            DELETE FROM category
            WHERE t.id_user = :userId AND t.name IN (:names)
            """, nativeQuery = true)
    void deleteCategory(String userId, String names);
}
