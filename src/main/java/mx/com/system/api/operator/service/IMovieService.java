package mx.com.system.api.operator.service;

import java.util.List;
import java.util.Set;
import mx.com.system.api.operator.dto.MovieDto;

public interface IMovieService {

  List<MovieDto> findAll();

  MovieDto findById(String id);

  MovieDto save(MovieDto item);

  void deleteMovie(String id);

  Set<MovieDto> searchMovie(String title, String description, String genre);
}
