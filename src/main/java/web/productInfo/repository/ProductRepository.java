package web.productInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.productInfo.models.ProductEntity;

/**
 * Created by WEO on 1/4/17.
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
