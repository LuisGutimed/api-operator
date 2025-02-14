package mx.com.system.api.operator.service;

import jakarta.annotation.Resource;
import jakarta.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import mx.com.system.api.operator.dto.PromotionDto;
import mx.com.system.api.operator.mapper.PromotionMapper;
import mx.com.system.api.operator.repository.PromotionRepository;
import org.springframework.stereotype.Service;

@Getter
@Service
public class IPromotionServiceImp implements IPromotionService {

  @Resource
  private PromotionRepository promotionRepository;

  @Resource
  private PromotionMapper promotionMapper;

  @Override
  public List<PromotionDto> findAll() {
    var promotionDtos = new ArrayList<PromotionDto>();
    getPromotionRepository().findAll()
        .forEach(
            promotion -> promotionDtos.add(getPromotionMapper().castPromotionToDto(promotion)));
    return promotionDtos;
  }

  @Override
  public PromotionDto findById(String id) {
    return getPromotionMapper().castPromotionToDto(
        getPromotionRepository().findById(id).orElseThrow(
            NotFoundException::new));
  }

  @Override
  public PromotionDto save(PromotionDto promotionDto) {
    var promotion = getPromotionRepository().save(
        getPromotionMapper().castDtoToPromotion(promotionDto));
    return getPromotionMapper().castPromotionToDto(promotion);
  }

  @Override
  public void deletePromotion(String id) {
    getPromotionRepository().deleteById(id);
  }
}
