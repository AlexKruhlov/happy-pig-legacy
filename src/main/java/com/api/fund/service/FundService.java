package com.api.fund.service;

import com.feature.fund.model.Fund;

import java.util.List;

public interface FundService {

    Fund findById(String id);

    List<Fund> findAll();
}
