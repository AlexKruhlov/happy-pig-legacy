package com.feature.prodposition.component;

import com.api.prodposition.component.ProductPositionComponent;
import com.api.prodposition.service.ProductPositionService;
import com.feature.prodposition.dto.ProductPositionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prodposition")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductPositionComponentImpl implements ProductPositionComponent {
    private final ProductPositionService productPositionService;

    @Override
    @GetMapping("/find/product/{productId}")
    public List<ProductPositionDto> findByProductId(@PathVariable String productId) {
        return productPositionService.findByProductId(productId);
    }
}
