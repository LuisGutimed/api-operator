package mx.com.system.api.operator.mapper;

import mx.com.system.api.operator.dto.MovieDto;
import mx.com.system.api.operator.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ItemMapper {

  MovieDto castItemToDto(final Movie movie);

  Movie castDtoToItem(final MovieDto movieDto);

}
