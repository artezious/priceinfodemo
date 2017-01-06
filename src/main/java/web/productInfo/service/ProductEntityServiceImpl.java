package web.productInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.productInfo.models.ProductEntity;
import web.productInfo.repository.ProductRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WEO on 1/4/17.
 */
@Service
public class ProductEntityServiceImpl implements ProductEntityService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public List<ProductEntity> findAllByName(String name) {
        List<ProductEntity> productEntitiesByName = new ArrayList<>();
        for (ProductEntity productEntity : productRepository.findAll()) {
            System.out.println(productEntity.getProductname());
            if (productEntity.getProductname().equals(name)) {
                productEntitiesByName.add(productEntity);
            }
        }
        return productEntitiesByName;
    }

    @Override
    @Transactional
    public List<ProductEntity> findAllByTimestamp(Timestamp timestamp) {

        List<ProductEntity> productEntitiesByTimestamp = new ArrayList<>();
        for (ProductEntity productEntity : productRepository.findAll()) {
            System.out.println(productEntity);
            if (productEntity.getTimestamp_ex().equals(timestamp)) {
                productEntitiesByTimestamp.add(productEntity);
            }
        }
        return productEntitiesByTimestamp;
    }

    @Override
    public void save(ProductEntity productEntity) {

        productEntity.setTimestamp_ex(new Timestamp(System.currentTimeMillis()));
        productRepository.save(productEntity);
    }

    @Override
    public void delete(ProductEntity productEntity) {

        productRepository.delete(productEntity);
    }
}
