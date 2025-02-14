package mx.com.system.api.operator.controller;

import jakarta.annotation.Resource;
import java.util.List;
import mx.com.system.api.operator.dto.PromotionDto;
import mx.com.system.api.operator.service.IPromotionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/promotion")
public class PromotionController {

  @Resource
  private IPromotionService iPromotionService;

  @GetMapping("/all")
  public List<PromotionDto> getAllPromotions() {
    return iPromotionService.findAll();
  }

  @GetMapping("/{id}")
  public PromotionDto getPromotionById(@PathVariable String id) {
    return iPromotionService.findById(id);
  }

  @PostMapping("/add")
  public PromotionDto createPromotion(@RequestBody PromotionDto item) {
    return iPromotionService.save(item);
  }

  @PutMapping("/{id}")
  public PromotionDto updatePromotion(@PathVariable String id, @RequestBody PromotionDto item) {
    item.setId(id);
    return iPromotionService.save(item);
  }

  @DeleteMapping("/{id}")
  public void deletePromotion(@PathVariable String id) {
    iPromotionService.deletePromotion(id);
  }

}
