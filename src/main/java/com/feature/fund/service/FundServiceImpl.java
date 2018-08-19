package com.feature.fund.service;

import com.api.fund.repository.FundRepository;
import com.api.fund.service.FundService;
import com.feature.fund.dto.FundDto;
import com.feature.fund.model.Fund;
import com.feature.fund.transformer.FundTransformer;
import com.feature.item.model.Item;
import com.feature.item.model.ItemTypeConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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
        Fund fund = addAmount(fundRepository.findById(id));
        return fundTransformer.toDto(fund);
    }

    @Override
    public List<FundDto> findAll() {
        return fundRepository.findAll().stream()
                .map(this::addAmount)
                .map(fundTransformer::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FundDto saveOrUpdate(FundDto fundDto) {
        Fund fund = fundTransformer.fromDto(fundDto);
        return fundTransformer.toDto(fundRepository.save(fund));
    }

    private Fund addAmount(Fund fund) {
        fund.setAmount(calculateAmount(fund.getItems()));
        return fund;
    }

    private BigInteger calculateAmount(List<Item> items) {
        return items.stream()
                .map(this::mapToPositiveOrNegative)
                .reduce(BigInteger::add).orElse(null);
    }

    private BigInteger mapToPositiveOrNegative(Item item) {
        return isExpense(item) ? item.getAmount().negate() : item.getAmount();
    }

    private boolean isExpense(Item item) {
        return item.getType().equals(ItemTypeConst.EXPENSE);
    }
}
