package com.feature.bankincomesource.controller;

import com.api.bankincomesource.controller.BankIncomeSourceController;
import com.api.bankincomesource.service.BankIncomeSourceService;
import com.feature.bankincomesource.dto.BankIncomeSourceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankincome/source")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BankIncomeSourceControllerImpl implements BankIncomeSourceController {
    private final BankIncomeSourceService bankIncomeSourceService;

    @Override
    @GetMapping("/all")
    public List<BankIncomeSourceDto> findAll() {
        return bankIncomeSourceService.findAll();
    }

    @Override
    @PostMapping("/save")
    public BankIncomeSourceDto save(@RequestBody BankIncomeSourceDto bankIncomeSource) {
        return bankIncomeSourceService.save(bankIncomeSource);
    }

    @Override
    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        bankIncomeSourceService.deleteById(id);
    }
}
