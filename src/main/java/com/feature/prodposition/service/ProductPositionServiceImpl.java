package com.feature.prodposition.service;

import com.api.prodposition.repository.ProductPositionRepository;
import com.api.prodposition.service.ProductPositionService;
import com.feature.prodposition.dto.ProductPositionDto;
import com.feature.prodposition.transformer.ProductPositionTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductPositionServiceImpl implements ProductPositionService {
    private final ProductPositionRepository productPositionRepository;
    private final ProductPositionTransformer productPositionTransformer;

    @Override
    @Transactional(readOnly = true)
    public List<ProductPositionDto> findByProductId(String productId) {
        return productPositionTransformer.toDtos(productPositionRepository.findByProductId(productId));
    }
}
