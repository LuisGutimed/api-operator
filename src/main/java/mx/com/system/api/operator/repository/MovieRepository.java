package mx.com.system.api.operator.repository;

import java.util.List;
import mx.com.system.api.operator.model.Movie;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, String> {

  List<Movie> findAllByTitleRegex(String title);

  List<Movie> findAllByGenreRegex(String genre);

  List<Movie> findAllByDescriptionRegex(String description);
}
