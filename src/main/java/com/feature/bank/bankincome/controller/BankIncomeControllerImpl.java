package com.feature.bank.bankincome.controller;

import com.api.bank.bankincome.controller.BankIncomeController;
import com.api.bank.bankincome.service.BankIncomeService;
import com.feature.bank.bankincome.dto.BankIncomeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankincome")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BankIncomeControllerImpl implements BankIncomeController {
    private final BankIncomeService bankIncomeService;

    @Override
    @GetMapping("/all")
    public List<BankIncomeDto> findAll() {
        return bankIncomeService.findAll();
    }

    @Override
    @GetMapping("/find/{bankIncomeId}")
    public BankIncomeDto findById(@PathVariable String bankIncomeId) {
        return bankIncomeService.findById(bankIncomeId);
    }

    @Override
    @PostMapping("/save")
    public BankIncomeDto save(@RequestBody BankIncomeDto bankIncomeDto) {
        return bankIncomeService.save(bankIncomeDto);
    }

    @Override
    @PostMapping("/delete/{bankIncomeId}")
    public void deleteById(@PathVariable String bankIncomeId) {
        bankIncomeService.deleteById(bankIncomeId);
    }
}
