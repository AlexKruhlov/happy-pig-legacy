package com.feature.prodposition;

import com.App;
import com.api.prodposition.service.ProductPositionService;
import com.feature.prodposition.dto.ProductPositionDto;
import com.feature.utils.TestUtilMethods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static com.feature.utils.TestUtilMethods.BALL_PRODUCT_ID;
import static com.feature.utils.TestUtilMethods.PIPE_PRODUCT_ID;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class ProductPositionServiceIntegrationTest {
    private static final int DATABASE_PRODUCT_POSITION_AMOUNT = 5;

    @Autowired
    private ProductPositionService productPositionService;

    @Test
    public void shouldFindAllProductPositions() {
        assertEquals(DATABASE_PRODUCT_POSITION_AMOUNT, productPositionService.findAll().size());
    }

    @Test
    public void shouldFindByProductId() {
        int productPositionDtoListSize = 2;
        assertEquals(productPositionDtoListSize, productPositionService.findByProductId(BALL_PRODUCT_ID).size());
    }

    @Test
    public void shouldFindByProductIdIfNotExists() {
        assertTrue(productPositionService.findByProductId(PIPE_PRODUCT_ID).isEmpty());
    }

    @Test
    public void shouldSaveProductPosition() {
        int expectedProductPositionAmount = DATABASE_PRODUCT_POSITION_AMOUNT + 1;
        ProductPositionDto productPositionDto = ProductPositionDto.builder()
                .product(TestUtilMethods.BALL_PRODUCT_DTO)
                .specification("Prod position spec").build();
        productPositionService.save(productPositionDto);
        assertEquals(expectedProductPositionAmount, productPositionService.findAll().size());
    }

    @Test
    public void shouldUpdateProductPosition() {
        ProductPositionDto productPositionDto = TestUtilMethods.createProductPositionDto();

        productPositionDto.setSpecification("New spec");
        productPositionService.save(productPositionDto);

        ProductPositionDto updatedProductPositionDto = productPositionService.findAll().stream()
                .filter(currProductPositionDto -> currProductPositionDto.getId().equals(productPositionDto.getId()))
                .findFirst().orElse(null);
        assertNotNull(updatedProductPositionDto);
        assertEquals(productPositionDto.getSpecification(), updatedProductPositionDto.getSpecification());
    }

    @Test
    public void shouldDeleteProductPosition() {
        int expectedProductPositionAmount = DATABASE_PRODUCT_POSITION_AMOUNT - 1;
        productPositionService.deleteById(TestUtilMethods.POTATOE_PRODUCT_POSITION_ID);
        assertEquals(expectedProductPositionAmount, productPositionService.findAll().size());
    }
}
