package mx.com.system.api.operator.service;

import jakarta.annotation.Resource;
import jakarta.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import mx.com.system.api.operator.dto.CategoryDto;
import mx.com.system.api.operator.mapper.CategoryMapper;
import mx.com.system.api.operator.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Getter
@Service
public class CategoryServiceImp implements ICategoryService {

  @Resource
  private CategoryRepository categoryRepository;

  @Resource
  private CategoryMapper categoryMapper;

  @Override
  public List<CategoryDto> findAll() {
    var categoryDtos = new ArrayList<CategoryDto>();
    getCategoryRepository().findAll()
        .forEach(category -> categoryDtos.add(getCategoryMapper().castCategoryToDto(category)));
    return categoryDtos;
  }

  @Override
  public CategoryDto findById(String id) {
    return getCategoryMapper().castCategoryToDto(getCategoryRepository().findById(id).orElseThrow(
        NotFoundException::new));
  }

  @Override
  public CategoryDto save(CategoryDto categoryDto) {
    var category = getCategoryRepository().save(getCategoryMapper().castDtoToCategory(categoryDto));
    return getCategoryMapper().castCategoryToDto(category);
  }

  @Override
  public void deleteCategory(String id) {
    getCategoryRepository().deleteById(id);
  }

  @Override
  public List<CategoryDto> searchCategory(String name, String description) {
    var categoryDtos = new ArrayList<CategoryDto>();
    getCategoryRepository().findAllByNameOrDescription(name, description)
        .forEach(category -> categoryDtos.add(getCategoryMapper().castCategoryToDto(category)));
    return categoryDtos;
  }
}
