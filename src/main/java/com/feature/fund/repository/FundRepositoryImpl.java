package com.feature.fund.repository;

import com.api.fund.repository.FundRepository;
import com.feature.fund.model.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FundRepositoryImpl implements FundRepository {

    private final FundDefaultRepository fundDefaultRepository;

    @Autowired
    public FundRepositoryImpl(FundDefaultRepository fundDefaultRepository) {
        this.fundDefaultRepository = fundDefaultRepository;
    }

    @Override
    public List<Fund> findAll() {
        return (List<Fund>) fundDefaultRepository.findAll();
    }

    @Override
    public Fund findById(String id) {
        return fundDefaultRepository.findById(id).orElse(null);
    }
}
