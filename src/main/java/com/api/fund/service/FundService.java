package com.api.fund.service;

import com.feature.fund.dto.FundDto;
import com.feature.fund.dto.FundDtoWithItems;

import java.util.List;

public interface FundService {

    FundDto findById(String id);

    List<FundDto> findAll();

    FundDtoWithItems saveOrUpdate(FundDtoWithItems fundDtoWithItems);
}
