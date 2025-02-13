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

    @PostMapping("")
    public ResponseEntity<Void> addCategory(@RequestBody List<CategoryRecord> records) {
        try{
            categoryService.saveCategory(records);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        return ResponseEntity.ok().build();
    }
}
