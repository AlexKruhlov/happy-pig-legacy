package com.feature.fund.controller;

import com.api.fund.controller.FundController;
import com.api.fund.service.FundService;
import com.feature.fund.model.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fund")
public class FundControllerImpl implements FundController {
    private FundService fundService;

    @Autowired
    public FundControllerImpl(FundService fundService) {
        this.fundService = fundService;
    }

    @Override
    @GetMapping("/{id}")
    public Fund findById(@PathVariable String id) {
        return fundService.findById(id);
    }

    @Override
    @GetMapping("/all")
    public List<Fund> findAll() {
        return fundService.findAll();
    }
}
