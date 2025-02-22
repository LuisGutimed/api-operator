package mx.com.system.api.operator.repository;

import java.util.List;
import mx.com.system.api.operator.model.Category;
import mx.com.system.api.operator.model.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ElasticsearchRepository<Item, String> {

  List<Item> findAllByStatusIsTrue();

  List<Item> findAllByCategoryOrDescriptionContains(Category category, String description);

}
