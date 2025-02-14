package mx.com.system.api.operator.service;

import java.util.List;
import mx.com.system.api.operator.dto.PromotionDto;

public interface IPromotionService {

  List<PromotionDto> findAll();

  PromotionDto findById(String id);

  PromotionDto save(PromotionDto item);

  void deletePromotion(String id);

}
