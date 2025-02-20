package mx.com.system.api.operator.repository;

import mx.com.system.api.operator.model.Promotion;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends ElasticsearchRepository<Promotion, String> {

}
