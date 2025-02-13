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

    public void saveCategory(List<CategoryRecord> records) {
        int order = 0;

        List<Category> categories = categoryRepository.findByIdUser("huyvulccd");
        Map<String, Long> namesRefId = categories.stream().collect(Collectors.toMap(Category::getName, Category::getId));

        String namesToDelete = records.stream().filter(CategoryRecord::isDelete)
                .map(CategoryRecord::name)
                .collect(Collectors.joining(","));
        categoryRepository.deleteCategory("huyvulccd", namesToDelete);

        List<CategoryRecord> recordsToSave = records.stream().filter(e -> e.isEdit() || e.isCreate()).toList();

        for (CategoryRecord record : recordsToSave) {
            Category category = new Category();
            category.setIdUser("huyvulccd");
            category.setName(record.name());
            category.setSubCategory(String.join(",", record.subCategories()));
            category.setSortOrder((byte) order++);
            category.setTracking(record.isTracking());

            if (record.isEdit()) {
                category.setId(namesRefId.get(record.name()));
            }
            categoryRepository.save(category);
        }
    }
}
