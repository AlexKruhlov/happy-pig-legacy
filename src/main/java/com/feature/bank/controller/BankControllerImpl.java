package com.feature.bank.controller;

import com.api.bank.controller.BankController;
import com.api.bank.service.BankService;
import com.feature.bank.dto.BankDto;
import com.feature.bank.transformer.BankTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BankControllerImpl implements BankController {
    private final BankService bankService;
    private final BankTransformer bankTransformer;

    @Override
    @GetMapping
    public BankDto getBank() {
        return bankTransformer.toDto(bankService.getBank());
    }
}
