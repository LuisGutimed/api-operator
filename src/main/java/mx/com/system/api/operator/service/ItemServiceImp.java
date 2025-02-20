package mx.com.system.api.operator.service;

import jakarta.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import mx.com.system.api.operator.dto.ItemDto;
import mx.com.system.api.operator.exceptions.NotFoundException;
import mx.com.system.api.operator.mapper.CategoryMapper;
import mx.com.system.api.operator.mapper.ItemMapper;
import mx.com.system.api.operator.model.Category;
import mx.com.system.api.operator.repository.CategoryRepository;
import mx.com.system.api.operator.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Getter
@Service
public class ItemServiceImp implements IItemService {

  @Resource
  private ItemRepository itemRepository;

  @Resource
  private CategoryRepository categoryRepository;

  @Resource
  private ItemMapper itemMapper;

  @Resource
  private CategoryMapper categoryMapper;

  @Override
  public List<ItemDto> findAll() {
    var itemDtos = new ArrayList<ItemDto>();
    getItemRepository().findAllByStatusIsTrue()
        .forEach(item -> itemDtos.add(getItemMapper().castItemToDto(item)));
    return itemDtos;
  }

  @Override
  public ItemDto findById(String id) {
    var itemDto = getItemRepository().findById(id);
    if (itemDto.isPresent()) {
      return getItemMapper().castItemToDto(itemDto.get());
    } else {
      throw new NotFoundException("Item not found");
    }
  }

  @Override
  public ItemDto save(ItemDto itemDto) {
    var categoryDto = itemDto.getCategory();
    var category = categoryRepository.findById(categoryDto.getId());
    if (category.isPresent()) {
      categoryDto = categoryMapper.castCategoryToDto(category.get());
      itemDto.setCategory(categoryDto);
    } else {
      throw new NotFoundException(
          "Category not found, you cannot save an item without an existing category");
    }
    var item = getItemRepository().save(getItemMapper().castDtoToItem(itemDto));
    return getItemMapper().castItemToDto(item);
  }

  @Override
  public void deleteItem(String id) {
    getItemRepository().deleteById(id);
  }

  @Override
  public List<ItemDto> searchItem(String category, String description) {
    var categoryItem = new Category();
    categoryItem.setId(category);
    var itemDtos = new ArrayList<ItemDto>();
    getItemRepository().findAllByCategoryOrDescriptionContains(categoryItem, description)
        .forEach(item -> itemDtos.add(getItemMapper().castItemToDto(item)));
    return itemDtos;
  }
}
