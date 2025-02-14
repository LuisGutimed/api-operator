package mx.com.system.api.operator.mapper;

import mx.com.system.api.operator.dto.PromotionDto;
import mx.com.system.api.operator.model.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PromotionMapper {

  @Mapping(target = "id", source = "promotion.id")
  @Mapping(target = "name", source = "promotion.name")
  @Mapping(target = "description", source = "promotion.description")
  @Mapping(target = "image", source = "promotion.image")
  @Mapping(target = "status", source = "promotion.status")
  @Mapping(target = "startDate", source = "promotion.startDate")
  @Mapping(target = "endDate", source = "promotion.endDate")
  PromotionDto castPromotionToDto(final Promotion promotion);

  @Mapping(target = "id", source = "promotionDto.id")
  @Mapping(target = "name", source = "promotionDto.name")
  @Mapping(target = "description", source = "promotionDto.description")
  @Mapping(target = "image", source = "promotionDto.image")
  @Mapping(target = "status", source = "promotionDto.status")
  @Mapping(target = "startDate", source = "promotionDto.startDate")
  @Mapping(target = "endDate", source = "promotionDto.endDate")
  Promotion castDtoToPromotion(final PromotionDto promotionDto);

}
