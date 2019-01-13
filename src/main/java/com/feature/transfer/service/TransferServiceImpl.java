package com.feature.transfer.service;

import com.api.transfer.repository.TransferRepository;
import com.api.transfer.service.TransferService;
import com.feature.transfer.dto.TransferWithFundsDto;
import com.feature.transfer.model.Transfer;
import com.feature.transfer.transformer.TransferWithFundsTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implements service layer API to work with {@link Transfer} objects
 */
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class TransferServiceImpl implements TransferService {
    private final TransferRepository transferRepository;
    private final TransferWithFundsTransformer transferWithFundsTransformer;

    @Override
    @Transactional(readOnly = true)
    public List<TransferWithFundsDto> findAll() {
        return transferRepository.findAll().stream()
                .map(transferWithFundsTransformer::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TransferWithFundsDto save(TransferWithFundsDto transferWithFundsDto) {
        Transfer transfer = transferRepository.save(transferWithFundsTransformer.fromDto(transferWithFundsDto));
        transferRepository.flush();
        return transferWithFundsTransformer.toDto(transferRepository.findById(transfer.getId()).orElse(null));
    }
}
