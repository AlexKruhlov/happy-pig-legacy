package com.feature.fund.service;

import com.api.fund.repository.FundRepository;
import com.api.fund.service.FundService;
import com.feature.fund.dto.FundDto;
import com.feature.fund.model.Fund;
import com.feature.fund.transformer.FundTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FundServiceImpl implements FundService {
    private final FundRepository fundRepository;
    private final FundTransformer fundTransformer;

    @Autowired
    public FundServiceImpl(FundRepository fundRepository, FundTransformer fundTransformer) {
        this.fundRepository = fundRepository;
        this.fundTransformer = fundTransformer;
    }

    @Override
    public FundDto findById(String id) {
        return fundTransformer.toDto(fundRepository.findById(id));
    }

    @Override
    public List<FundDto> findAll() {
        return fundRepository.findAll().stream()
                .map(fundTransformer::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FundDto saveOrUpdate(FundDto fundDto) {
        Fund fund = fundTransformer.fromDto(fundDto);
        return fundTransformer.toDto(fundRepository.save(fund));
    }
}
