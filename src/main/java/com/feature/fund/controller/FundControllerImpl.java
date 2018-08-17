package com.feature.fund.controller;

import com.api.fund.controller.FundController;
import com.api.fund.service.FundService;
import com.feature.fund.dto.FundDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fund")
public class FundControllerImpl implements FundController {
    private final FundService fundService;

    @Autowired
    public FundControllerImpl(FundService fundService) {
        this.fundService = fundService;
    }

    @Override
    @GetMapping("/{id}")
    public FundDto findById(@PathVariable String id) {
        return fundService.findById(id);
    }

    @Override
    @GetMapping("/all")
    public List<FundDto> findAll() {
        return fundService.findAll();
    }

    @Override
    @PostMapping("/save")
    public FundDto saveOrUpdate(@RequestBody FundDto fundDto) {
        return fundService.saveOrUpdate(fundDto);
    }
}
