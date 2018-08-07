package com.controller;

import com.model.Fund;
import com.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fund")
public class FundController {

    private FundService fundService;

    @Autowired
    public FundController(FundService fundService) {
        this.fundService = fundService;
    }

    @GetMapping("/{id}")
    public Fund findById(@PathVariable String id) {
        return fundService.findById(id);
    }

    @GetMapping("/all")
    public List<Fund> findAll() {
        return fundService.findAll();
    }
}
