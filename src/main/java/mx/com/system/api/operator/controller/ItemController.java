package mx.com.system.api.operator.controller;

import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import mx.com.system.api.operator.dto.MovieDto;
import mx.com.system.api.operator.service.IMovieService;
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
@RequestMapping("${api-operator.rest.base-path}")
public class ItemController {

  @Resource
  private IMovieService itemService;

  @GetMapping("${api-operator.rest.get-movies}")
  public List<MovieDto> getAllItems() {
    return itemService.findAll();
  }

  @GetMapping("${api-operator.rest.get-movie}")
  public MovieDto getItemById(@PathVariable String id) {
    return itemService.findById(id);
  }

  @PostMapping("${api-operator.rest.add-movie}")
  public MovieDto createItem(@RequestBody MovieDto item) {
    return itemService.save(item);
  }

  @PutMapping("${api-operator.rest.edit-movie}")
  public MovieDto updateItem(@PathVariable String id, @RequestBody MovieDto item) {
    item.setId(id);
    return itemService.save(item);
  }

  @DeleteMapping("${api-operator.rest.delete-movie}")
  public void deleteItem(@PathVariable String id) {
    itemService.deleteMovie(id);
  }

  @GetMapping("${api-operator.rest.search}")
  public Set<MovieDto> searchMovie(@RequestParam(required = false) String title,
      @RequestParam(required = false) String description,
      @RequestParam(required = false) String genre) {
    return itemService.searchMovie(title, description, genre);
  }

}
