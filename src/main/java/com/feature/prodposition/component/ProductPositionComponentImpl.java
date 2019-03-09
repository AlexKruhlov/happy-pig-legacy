package com.feature.prodposition.component;

import com.api.prodposition.component.ProductPositionComponent;
import com.api.prodposition.service.ProductPositionService;
import com.feature.prodposition.dto.ProductPositionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prodposition")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductPositionComponentImpl implements ProductPositionComponent {
    private final ProductPositionService productPositionService;

    @Override
    @GetMapping("/find/all")
    public List<ProductPositionDto> findAll() {
        return productPositionService.findAll();
    }

    @Override
    @GetMapping("/find/product/{productId}")
    public List<ProductPositionDto> findByProductId(@PathVariable String productId) {
        return productPositionService.findByProductId(productId);
    }

    @Override
    @PostMapping("/save")
    public ProductPositionDto save(@RequestBody ProductPositionDto productPositionDto) {
        return productPositionService.save(productPositionDto);
    }

    @Override
    @PostMapping("/delete/{productPositionId}")
    public void deleteById(@PathVariable String productPositionId) {
        productPositionService.deleteById(productPositionId);
    }
}
