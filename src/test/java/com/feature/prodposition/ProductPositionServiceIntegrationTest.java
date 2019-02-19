package com.feature.prodposition;

import com.App;
import com.api.prodposition.service.ProductPositionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static com.feature.utils.TestUtilMethods.BALL_PRODUCT_ID;
import static com.feature.utils.TestUtilMethods.PIPE_PRODUCT_ID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class ProductPositionServiceIntegrationTest {

    @Autowired
    private ProductPositionService productPositionService;

    @Test
    public void shouldFindByProductId() {
        int productPositionDtoListSize = 2;
        assertEquals(productPositionDtoListSize, productPositionService.findByProductId(BALL_PRODUCT_ID).size());
    }

    @Test
    public void shouldFindByProductIdIfNotExists() {
        assertTrue(productPositionService.findByProductId(PIPE_PRODUCT_ID).isEmpty());
    }
}
