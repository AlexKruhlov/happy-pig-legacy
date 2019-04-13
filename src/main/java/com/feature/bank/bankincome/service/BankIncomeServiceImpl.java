package com.feature.bank.bankincome.service;

import com.api.bank.bankincome.repository.BankIncomeRepository;
import com.api.bank.bankincome.service.BankIncomeService;
import com.feature.bank.bankincome.dto.BankIncomeDto;
import com.feature.bank.bankincome.model.BankIncome;
import com.feature.bank.bankincome.transformer.BankIncomeTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BankIncomeServiceImpl implements BankIncomeService {
    private final BankIncomeRepository bankIncomeRepository;
    private final BankIncomeTransformer bankIncomeTransformer;

    @Override
    @Transactional(readOnly = true)
    public List<BankIncomeDto> findAll() {
        return bankIncomeTransformer.toDtos(bankIncomeRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public BankIncomeDto findById(String bankIncomeId) {
        return bankIncomeTransformer.toDto(bankIncomeRepository.findById(bankIncomeId).orElse(null));
    }

    @Override
    public BankIncomeDto save(BankIncomeDto bankIncomeDto) {
        BankIncome bankIncome = bankIncomeTransformer.fromDto(bankIncomeDto);
        final String savedBankIncomeId = bankIncomeRepository.saveAndFlush(bankIncome).getId();
        return findById(savedBankIncomeId);
    }

    @Override
    public void deleteById(String bankIncomeId) {
        BankIncome bankIncome = bankIncomeRepository.findById(bankIncomeId).orElse(null);
        if (nonNull(bankIncome)) {
            bankIncome.setDeleted(true);
            bankIncomeRepository.save(bankIncome);
        }
    }
}
