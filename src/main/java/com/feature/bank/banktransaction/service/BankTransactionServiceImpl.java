package com.feature.bank.banktransaction.service;

import com.api.bank.banktransaction.repository.BankTransactionRepository;
import com.api.bank.banktransaction.service.BankTransactionService;
import com.feature.bank.banktransaction.dto.BankTransactionDto;
import com.feature.bank.banktransaction.model.BankTransaction;
import com.feature.bank.banktransaction.transformer.BankTransactionTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Transactional
public class BankTransactionServiceImpl implements BankTransactionService {
    private final BankTransactionRepository bankTransactionRepository;
    private final BankTransactionTransformer bankTransactionTransformer;

    @Override
    @Transactional(readOnly = true)
    public List<BankTransactionDto> findAll() {
        return bankTransactionTransformer.toDtos(bankTransactionRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public BankTransactionDto findById(String bankTransactionId) {
        return bankTransactionTransformer
                .toDto(bankTransactionRepository.findById(bankTransactionId).orElse(null));
    }

    @Override
    public BankTransactionDto save(BankTransactionDto bankTransactionDto) {
        String savedBankTransactionId =
                bankTransactionRepository.saveAndFlush(bankTransactionTransformer.fromDto(bankTransactionDto)).getId();
        return findById(savedBankTransactionId);
    }

    @Override
    public void deleteById(String bankTransactionId) {
        BankTransaction bankTransaction = bankTransactionRepository.findById(bankTransactionId).orElse(null);
        if(nonNull(bankTransaction)){
            bankTransaction.setDeleted(true);
            bankTransactionRepository.save(bankTransaction);
        }
    }
}
