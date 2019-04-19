package com.feature.bank.banktransaction.controller;

import com.api.bank.banktransaction.controller.BankTransactionController;
import com.api.bank.banktransaction.service.BankTransactionService;
import com.feature.bank.banktransaction.dto.BankTransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/transaction")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BankTransactionControllerImpl implements BankTransactionController {
    private final BankTransactionService bankTransactionService;

    @Override
    @GetMapping("/all")
    public List<BankTransactionDto> findAll() {
        return bankTransactionService.findAll();
    }

    @Override
    @GetMapping("/{bankTransactionId}")
    public BankTransactionDto findById(@PathVariable String bankTransactionId) {
        return bankTransactionService.findById(bankTransactionId);
    }

    @Override
    @PostMapping("/save")
    public BankTransactionDto save(@RequestBody BankTransactionDto bankTransactionDto) {
        return bankTransactionService.save(bankTransactionDto);
    }

    @Override
    @PostMapping("/delete/{bankTransactionId}")
    public void deleteById(@PathVariable String bankTransactionId) {
        bankTransactionService.deleteById(bankTransactionId);
    }
}
