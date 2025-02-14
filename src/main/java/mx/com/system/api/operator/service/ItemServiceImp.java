package mx.com.system.api.operator.service;

import jakarta.annotation.Resource;
import jakarta.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.Getter;
import mx.com.system.api.operator.dto.ItemDto;
import mx.com.system.api.operator.mapper.ItemMapper;
import mx.com.system.api.operator.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Getter
@Service
public class ItemServiceImp implements IItemService {

  @Resource
  private ItemRepository itemRepository;

  @Resource
  private ItemMapper itemMapper;

  @Override
  public List<ItemDto> findAll() {
    var itemDtos = new ArrayList<ItemDto>();
    getItemRepository().findAll()
        .forEach(item -> itemDtos.add(getItemMapper().castItemToDto(item)));
    return itemDtos;
  }

  @Override
  public ItemDto findById(String id) {
    return getItemMapper().castItemToDto(getItemRepository().findById(id).orElseThrow(
        NotFoundException::new));
  }

  @Override
  public ItemDto save(ItemDto itemDto) {
    var item = getItemRepository().save(getItemMapper().castDtoToItem(itemDto));
    return getItemMapper().castItemToDto(item);
  }

  @Override
  public void deleteItem(String id) {
    getItemRepository().deleteById(id);
  }
}
