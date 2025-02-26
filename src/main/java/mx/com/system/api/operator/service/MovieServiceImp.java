package mx.com.system.api.operator.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import lombok.Getter;
import mx.com.system.api.operator.dto.MovieDto;
import mx.com.system.api.operator.exceptions.NotFoundException;
import mx.com.system.api.operator.mapper.ItemMapper;
import mx.com.system.api.operator.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Getter
@Service
public class MovieServiceImp implements IMovieService {

  @Resource
  private MovieRepository movieRepository;

  @Resource
  private ItemMapper itemMapper;


  @Override
  public List<MovieDto> findAll() {
    var itemDtos = new ArrayList<MovieDto>();
    getMovieRepository().findAll()
        .forEach(item -> itemDtos.add(getItemMapper().castItemToDto(item)));
    return itemDtos;
  }

  @Override
  public MovieDto findById(String id) {
    var itemDto = getMovieRepository().findById(id);
    if (itemDto.isPresent()) {
      return getItemMapper().castItemToDto(itemDto.get());
    } else {
      throw new NotFoundException("Movie not found");
    }
  }

  @Override
  public MovieDto save(MovieDto movieDto) {
    var item = getMovieRepository().save(getItemMapper().castDtoToItem(movieDto));
    return getItemMapper().castItemToDto(item);
  }

  @Override
  public void deleteMovie(String id) {
    getMovieRepository().deleteById(id);
  }

  @Override
  public Set<MovieDto> searchMovie(String title, String description, String genre) {
    var itemDtos = new HashSet<MovieDto>();
    if (StringUtils.hasText(title)) {
      getMovieRepository().findAllByTitleRegex("*" + title + "*")
          .forEach(item -> itemDtos.add(getItemMapper().castItemToDto(item)));
    }

    if (StringUtils.hasText(description)) {
      getMovieRepository().findAllByDescriptionRegex("*" + description + "*")
          .forEach(item -> itemDtos.add(getItemMapper().castItemToDto(item)));
    }

    if (StringUtils.hasText(genre)) {
      getMovieRepository().findAllByGenreRegex("*" + genre + "*")
          .forEach(item -> itemDtos.add(getItemMapper().castItemToDto(item)));
    }

    return itemDtos;
  }
}
