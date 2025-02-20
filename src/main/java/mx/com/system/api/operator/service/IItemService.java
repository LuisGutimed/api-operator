package mx.com.system.api.operator.service;

import java.util.List;
import mx.com.system.api.operator.dto.ItemDto;

public interface IItemService {

  List<ItemDto> findAll();

  ItemDto findById(String id);

  ItemDto save(ItemDto item);

  void deleteItem(String id);

  List<ItemDto> searchItem(String category, String description);
}
