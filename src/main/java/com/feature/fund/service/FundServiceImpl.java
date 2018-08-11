package com.feature.fund.service;

import com.api.fund.service.FundService;
import com.feature.fund.model.Fund;
import com.api.fund.repository.FundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundServiceImpl implements FundService {
    private FundRepository fundRepository;

    @Autowired
    public FundServiceImpl(FundRepository fundRepository) {
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
