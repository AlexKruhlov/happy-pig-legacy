package com.feature.fund.repository;

import com.api.fund.repository.FundRepository;
import com.feature.fund.model.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class FundRepositoryImpl implements FundRepository {

    private final FundDefaultRepository fundDefaultRepository;

    @Autowired
    public FundRepositoryImpl(FundDefaultRepository fundDefaultRepository) {
        this.fundDefaultRepository = fundDefaultRepository;
    }

    @Override
    @ReadOnlyProperty
    public List<Fund> findAll() {
        return (List<Fund>) fundDefaultRepository.findAll();
    }

    @Override
    @ReadOnlyProperty
    public Fund findById(String id) {
        return fundDefaultRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Fund save(Fund fund) {
        return fundDefaultRepository.save(fund);
    }
}
