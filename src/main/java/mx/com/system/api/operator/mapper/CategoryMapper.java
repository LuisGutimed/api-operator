package mx.com.system.api.operator.mapper;

import mx.com.system.api.operator.dto.CategoryDto;
import mx.com.system.api.operator.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

  @Mapping(target = "id", source = "category.id")
  @Mapping(target = "name", source = "category.name")
  @Mapping(target = "description", source = "category.description")
  CategoryDto castCategoryToDto(final Category category);

  @Mapping(target = "id", source = "categoryDto.id")
  @Mapping(target = "name", source = "categoryDto.name")
  @Mapping(target = "description", source = "categoryDto.description")
  Category castDtoToCategory(final CategoryDto categoryDto);

}
