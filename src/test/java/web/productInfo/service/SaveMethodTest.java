package web.productInfo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import web.productInfo.models.ProductEntity;
import web.productInfo.repository.ProductRepository;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by WEO on 1/6/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class SaveMethodTest {

    @Mock
    private ProductRepository productRepository;

    @Spy
    @InjectMocks
    private ProductEntityService productEntityService = new ProductEntityServiceImpl();



    @Test
    public void save() throws Exception {

        ProductEntity productEntityTest = new ProductEntity(1, "Apple", null, 2.3);

        productEntityService.save(productEntityTest);

        assertNotNull(productEntityTest.getTimestamp_ex());

        verify(productEntityService, times(1)).save(productEntityTest);

    }
}
