package mx.com.system.api.operator.repository;

import mx.com.system.api.operator.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, String> {

}
