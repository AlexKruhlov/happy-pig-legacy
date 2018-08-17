package com.api.fund.service;

import com.feature.fund.dto.FundDto;

import java.util.List;

public interface FundService {

    FundDto findById(String id);

    List<FundDto> findAll();

    FundDto saveOrUpdate(FundDto fundDto);
}
