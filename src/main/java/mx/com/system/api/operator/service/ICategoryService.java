package mx.com.system.api.operator.service;

import java.util.List;
import mx.com.system.api.operator.dto.CategoryDto;

public interface ICategoryService {

  List<CategoryDto> findAll();

  CategoryDto findById(String id);

  CategoryDto save(CategoryDto item);

  void deleteCategory(String id);

  List<CategoryDto> searchCategory(String category, String description);
}
