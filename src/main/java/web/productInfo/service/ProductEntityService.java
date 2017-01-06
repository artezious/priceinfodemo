package web.productInfo.service;

import web.productInfo.models.ProductEntity;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by WEO on 1/4/17.
 */
public interface ProductEntityService {

    List<ProductEntity> findAllByName(String name);

    List<ProductEntity> findAllByTimestamp (Timestamp timestamp);

    void save(ProductEntity productEntity);

    void delete(ProductEntity productEntity);
}

