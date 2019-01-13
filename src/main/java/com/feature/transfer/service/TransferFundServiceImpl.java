package com.feature.transfer.service;

import com.api.transfer.repository.TransferFundRepository;
import com.api.transfer.service.TransferFundService;
import com.feature.transfer.dto.TransferFundDto;
import com.feature.transfer.model.TransferFund;
import com.feature.transfer.transformer.TransferFundTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Provides service layer API implementation to work with {@link TransferFund} objects
 */
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class TransferFundServiceImpl implements TransferFundService {
    private final TransferFundRepository transferFundRepository;
    private final TransferFundTransformer transferFundTransformer;

    @Override
    @Transactional(readOnly = true)
    public List<TransferFundDto> findByFundId(String fundId) {
        return transferFundRepository.findByIdFundId(fundId).stream()
                .map(transferFundTransformer::toDto)
                .collect(toList());
    }
}
