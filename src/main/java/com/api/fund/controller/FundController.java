package com.api.fund.controller;

import com.feature.fund.dto.FundDto;
import com.feature.fund.dto.FundDtoWithItems;

import java.util.List;

public interface FundController {

    FundDto findById(String id);

    List<FundDto> findAll();

    FundDtoWithItems update(FundDtoWithItems fundDtoWithItems);

    List<FundDto> saveAndFindAll(FundDto fundDto);

    List<FundDto> deleteByIdAndFindAll(String id);
}
