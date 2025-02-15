package vunh.theodoi.chitieu.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vunh.theodoi.chitieu.dto.requests.CategoryRecord;
import vunh.theodoi.chitieu.dto.responses.CategoryResponse;
import vunh.theodoi.chitieu.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CategoryController {

    CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<CategoryResponse>> getCategory() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> addCategory(@RequestBody CategoryRecord record) {
        try{
            categoryService.saveCategory(record);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/updateSortOrder")
    public ResponseEntity<Void> updateSortOrder(@RequestBody List<String> records) {
        try{
            categoryService.updateSortOrder(records);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> editCategory(@RequestBody CategoryRecord record) {
        try{
            categoryService.saveCategory(record);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        try {
            categoryService.deleteCategory(id);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        return ResponseEntity.ok().build();
    }
}
