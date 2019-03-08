package com.feature.bankincomesource.service;

import com.api.bankincomesource.repository.BankIncomeSourceRepository;
import com.api.bankincomesource.service.BankIncomeSourceService;
import com.feature.bankincomesource.dto.BankIncomeSourceDto;
import com.feature.bankincomesource.model.BankIncomeSource;
import com.feature.bankincomesource.transformer.BankIncomeSourceTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BankIncomeSourceServiceImpl implements BankIncomeSourceService {
    private final BankIncomeSourceRepository bankIncomeSourceRepository;
    private final BankIncomeSourceTransformer bankIncomeSourceTransformer;

    @Override
    @Transactional(readOnly = true)
    public List<BankIncomeSourceDto> findAll() {
        return bankIncomeSourceTransformer.toDtos(bankIncomeSourceRepository.findAll());
    }

    @Override
    public BankIncomeSourceDto save(BankIncomeSourceDto bankIncomeSourceDto) {
        BankIncomeSource bankIncomeSource = bankIncomeSourceTransformer.fromDto(bankIncomeSourceDto);
        return bankIncomeSourceTransformer.toDto(bankIncomeSourceRepository.saveAndFlush(bankIncomeSource));
    }

    @Override
    public void deleteById(String bankIncomeSourceId) {
        BankIncomeSource bankIncomeSource = bankIncomeSourceRepository.findById(bankIncomeSourceId).orElse(null);
        if (nonNull(bankIncomeSource)) {
            bankIncomeSource.setDeleted(true);
            bankIncomeSourceRepository.saveAndFlush(bankIncomeSource);
        }
    }
}
