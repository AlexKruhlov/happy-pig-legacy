package com.feature.prodposition.service;

import com.api.prodposition.repository.ProductPositionRepository;
import com.api.prodposition.service.ProductPositionService;
import com.feature.prodposition.dto.ProductPositionDto;
import com.feature.prodposition.model.ProductPosition;
import com.feature.prodposition.transformer.ProductPositionTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductPositionServiceImpl implements ProductPositionService {
    private final ProductPositionRepository productPositionRepository;
    private final ProductPositionTransformer productPositionTransformer;

    @Override
    @Transactional(readOnly = true)
    public List<ProductPositionDto> findAll() {
        return productPositionTransformer.toDtos(productPositionRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductPositionDto> findByProductId(String productId) {
        return productPositionTransformer.toDtos(productPositionRepository.findByProductId(productId));
    }

    @Override
    public ProductPositionDto save(ProductPositionDto productPositionDto) {
        ProductPosition productPosition = productPositionTransformer.fromDto(productPositionDto);
        return productPositionTransformer.toDto(productPositionRepository.saveAndFlush(productPosition));
    }

    @Override
    public void deleteById(String productPositionId) {
        ProductPosition productPosition = productPositionRepository.findById(productPositionId).orElse(null);
        if (nonNull(productPosition)) {
            productPosition.setDeleted(true);
            productPositionRepository.saveAndFlush(productPosition);
        }
    }
}
