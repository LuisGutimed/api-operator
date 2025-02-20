package mx.com.system.api.operator.repository;

import java.util.List;
import mx.com.system.api.operator.model.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ElasticsearchRepository<Category, String> {

  List<Category> findAllByNameOrDescription(String name, String description);

}
