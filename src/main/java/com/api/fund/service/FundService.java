package com.api.fund.service;

import com.feature.fund.dto.FundDto;
import com.feature.fund.dto.FundDtoWithItems;

import java.util.List;

public interface FundService {

    FundDtoWithItems findById(String id);

    List<FundDto> findAll();

    FundDtoWithItems update(FundDtoWithItems fundDtoWithItems);

    FundDto save(FundDto fundDto);

    List<FundDto> saveAndFindAll(FundDto fundDto);

    List<FundDto> deleteByIdAndFindAll(String id);
}
