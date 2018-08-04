package com.service;

import com.model.Fund;
import com.repository.FundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundService {

    private FundRepository fundRepository;

    @Autowired
    public FundService(FundRepository fundRepository) {
        this.fundRepository = fundRepository;
    }

    public Fund findById(String id) {
        return fundRepository.findById(id).orElse(null);
    }
}
