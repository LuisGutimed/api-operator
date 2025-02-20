package mx.com.system.api.operator.controller;

import jakarta.annotation.Resource;
import java.util.List;
import mx.com.system.api.operator.dto.CategoryDto;
import mx.com.system.api.operator.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/api/category")
public class CategoryController {

  @Resource
  private ICategoryService categoryService;

  @GetMapping("/all")
  public List<CategoryDto> getAllCategorys() {
    return categoryService.findAll();
  }

  @GetMapping("/{id}")
  public CategoryDto getCategoryById(@PathVariable String id) {
    return categoryService.findById(id);
  }

  @PostMapping("/add")
  public CategoryDto createCategory(@RequestBody CategoryDto category) {
    return categoryService.save(category);
  }

  @PutMapping("/{id}")
  public CategoryDto updateCategory(@PathVariable String id, @RequestBody CategoryDto category) {
    category.setId(id);
    return categoryService.save(category);
  }

  @DeleteMapping("/{id}")
  public void deleteCategory(@PathVariable String id) {
    categoryService.deleteCategory(id);
  }

  @GetMapping("/find")
  public List<CategoryDto> searchCategory(@RequestParam String category,
      @RequestParam String description) {
    return categoryService.searchCategory(category, description);
  }

}
