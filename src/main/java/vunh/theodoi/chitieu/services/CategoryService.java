package vunh.theodoi.chitieu.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import vunh.theodoi.chitieu.dto.requests.CategoryRecord;
import vunh.theodoi.chitieu.dto.responses.CategoryResponse;
import vunh.theodoi.chitieu.entities.Category;
import vunh.theodoi.chitieu.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CategoryService {
    CategoryRepository categoryRepository;

    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findByIdUser("huyvulccd");
        List<CategoryResponse> responses = new ArrayList<>();
        categories.forEach(category -> responses.add(
                new CategoryResponse(category.getName(), category.getSubCategory().split(","), category.getSortOrder(), category.isTracking()))
        );
        return responses;
    }

    public void saveCategory(CategoryRecord records) {
        Category category = new Category();
        category.setName(records.name());
        category.setSubCategory(records.subCategories());
        category.setSortOrder(records.order());
        category.setTracking(records.isTracking());
        category.setColor(records.color());
        category.setIdUser("huyvulccd");
        if (records.id() != null)
            category.setId(records.id());

        categoryRepository.save(category);

    }

    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    public void updateSortOrder(List<String> records) {
        Map<String, Byte> sortedMap = new HashMap<>();
        for (byte i = 0; i < records.size(); i++) {
            sortedMap.put(records.get(i), i);
        }

        List<Category> categories = categoryRepository.findByIdUser("huyvulccd");

        for (Category category : categories) {
            Byte sortOrder = sortedMap.get(category.getName());
            if (sortOrder == null) {
                throw new IllegalStateException("Data is illegal!!!");
            }
            category.setSortOrder(sortOrder);
        }

        categoryRepository.saveAll(categories);
    }
}
