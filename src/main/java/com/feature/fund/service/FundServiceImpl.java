package com.feature.fund.service;

import com.api.fund.service.FundService;
import com.feature.fund.model.Fund;
import com.feature.fund.repository.FundDefaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundServiceImpl implements FundService {
    private final FundDefaultRepository fundRepository;

    @Autowired
    public FundServiceImpl(FundDefaultRepository fundRepository) {
        this.fundRepository = fundRepository;
    }

    @Override
    public Fund findById(String id) {
        return fundRepository.findById(id).orElse(null);
    }

    @Override
    public List<Fund> findAll() {
        return (List<Fund>) fundRepository.findAll();
    }
}
