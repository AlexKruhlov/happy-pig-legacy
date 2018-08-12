package com.api.fund.repository;

import com.feature.fund.model.Fund;

import java.util.List;

public interface FundRepository {

    List<Fund> findAll();

    Fund findById(String id);
}
