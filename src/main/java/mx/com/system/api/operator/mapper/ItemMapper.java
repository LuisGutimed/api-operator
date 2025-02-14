package mx.com.system.api.operator.mapper;

import mx.com.system.api.operator.dto.ItemDto;
import mx.com.system.api.operator.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ItemMapper {

  @Mapping(target = "id", source = "item.id")
  @Mapping(target = "name", source = "item.name")
  @Mapping(target = "description", source = "item.description")
  @Mapping(target = "image", source = "item.image")
  @Mapping(target = "category.id", source = "item.category.id")
  @Mapping(target = "category.name", source = "item.category.name")
  @Mapping(target = "category.description", source = "item.category.description")
  @Mapping(target = "status", source = "item.status")
  @Mapping(target = "price", source = "item.price")
  ItemDto castItemToDto(final Item item);

  @Mapping(target = "id", source = "itemDto.id")
  @Mapping(target = "name", source = "itemDto.name")
  @Mapping(target = "description", source = "itemDto.description")
  @Mapping(target = "image", source = "itemDto.image")
  @Mapping(target = "category.id", source = "itemDto.category.id")
  @Mapping(target = "status", source = "itemDto.status")
  @Mapping(target = "price", source = "itemDto.price")
  Item castDtoToItem(final ItemDto itemDto);

}
