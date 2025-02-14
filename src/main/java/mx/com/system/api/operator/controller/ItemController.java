package mx.com.system.api.operator.controller;

import jakarta.annotation.Resource;
import java.util.List;
import mx.com.system.api.operator.dto.ItemDto;
import mx.com.system.api.operator.service.IItemService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemController {

  @Resource
  private IItemService itemService;

  @GetMapping("/all")
  public List<ItemDto> getAllItems() {
    return itemService.findAll();
  }

  @GetMapping("/{id}")
  public ItemDto getItemById(@PathVariable String id) {
    return itemService.findById(id);
  }

  @PostMapping("/add")
  public ItemDto createItem(@RequestBody ItemDto item) {
    return itemService.save(item);
  }

  @PutMapping("/{id}")
  public ItemDto updateItem(@PathVariable String id, @RequestBody ItemDto item) {
    item.setId(id);
    return itemService.save(item);
  }

  @DeleteMapping("/{id}")
  public void deleteItem(@PathVariable String id) {
    itemService.deleteItem(id);
  }

}
