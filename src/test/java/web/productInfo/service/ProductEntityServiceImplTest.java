package web.productInfo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import web.productInfo.models.ProductEntity;
import web.productInfo.repository.ProductRepository;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertSame;
import static org.mockito.Mockito.*;

/**
 * Created by WEO on 1/6/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductEntityServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductEntityService productEntityService = new ProductEntityServiceImpl();

    @Test
    public void findAllByName() throws Exception {

        List<ProductEntity> expectedUsers = Arrays.asList(new ProductEntity(1, "Apple", Timestamp.valueOf("2017-01-06 00:59:44"), 2.12));
        when(productEntityService.findAllByName("Apple")).thenReturn(expectedUsers);
        List<ProductEntity> actual = productEntityService.findAllByName("Apple");
        assertSame(actual, expectedUsers);
        verify(productEntityService, times(1)).findAllByName("Apple");
    }

    @Test
    public void findAllByTimestamp() throws Exception {
        List<ProductEntity> expectedUsers = Arrays.asList(new ProductEntity(1, "Apple", Timestamp.valueOf("2017-01-06 00:59:44"), 2.12));
        when(productEntityService.findAllByTimestamp(Timestamp.valueOf("2017-01-06 00:59:44"))).thenReturn(expectedUsers);
        List<ProductEntity> actual = productEntityService.findAllByTimestamp(Timestamp.valueOf("2017-01-06 00:59:44"));
        assertSame(actual, expectedUsers);
        verify(productEntityService, times(1)).findAllByTimestamp(Timestamp.valueOf("2017-01-06 00:59:44"));
    }


    @Test
    public void delete() throws Exception {

        ProductEntity productEntityTest = new ProductEntity(1, "Apple", null, 2.3);

        productEntityService.delete(productEntityTest);

        verify(productEntityService, times(1)).delete(productEntityTest);

    }

}