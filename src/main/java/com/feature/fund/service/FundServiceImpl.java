package com.feature.fund.service;

import com.api.fund.repository.FundRepository;
import com.api.fund.service.FundService;
import com.feature.fund.dto.FundDto;
import com.feature.fund.dto.FundDtoWithItems;
import com.feature.fund.model.Fund;
import com.feature.fund.transformer.FundTransformer;
import com.feature.item.model.Item;
import com.feature.item.model.ItemTypeConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class FundServiceImpl implements FundService {

    private final class FundAmount {
        public BigInteger currentAmount = BigInteger.ZERO;
        public BigInteger income = BigInteger.ZERO;
        public BigInteger expense = BigInteger.ZERO;
    }

    private final FundRepository fundRepository;
    private final FundTransformer fundTransformer;

    @Autowired
    public FundServiceImpl(FundRepository fundRepository, FundTransformer fundTransformer) {
        this.fundRepository = fundRepository;
        this.fundTransformer = fundTransformer;
    }

    @Override
    @Transactional(readOnly = true)
    public FundDtoWithItems findById(String id) {
        Fund fund = addAmount(fundRepository.findById(id).orElse(null));
        return fundTransformer.toDtoWithItems(fund);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FundDto> findAll() {
        return fundRepository.findAll().stream()
                .map(this::addAmount)
                .map(fundTransformer::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public FundDtoWithItems update(FundDtoWithItems fundDtoWithItems) {
        Fund savedFund = fundRepository.save(fundTransformer.fromDtoWithItems(fundDtoWithItems));
        Fund savedFundWithAmounts = addAmount(savedFund);
        return fundTransformer.toDtoWithItems(savedFundWithAmounts);
    }

    @Override
    @Transactional
    public FundDto save(FundDto fundDto) {
        Fund savedFund = fundRepository.save(fundTransformer.fromDto(fundDto));
        return fundTransformer.toDto(savedFund);
    }

    @Override
    @Transactional
    public List<FundDto> saveAndFindAll(FundDto fundDto) {
        fundRepository.save(fundTransformer.fromDto(fundDto));
        return findAll();
    }

    @Override
    @Transactional
    public List<FundDto> deleteByIdAndFindAll(String id){
        fundRepository.deleteById(id);
        return findAll();
    }

    private Fund addAmount(Fund fund) {
        if (isNull(fund)) {
            return null;
        }
        FundAmount fundAmount = calculateAmount(fund.getItems());
        fund.setAmount(fundAmount.currentAmount);
        fund.setExpense(fundAmount.expense);
        fund.setIncome(fundAmount.income);
        return fund;
    }

    private FundAmount calculateAmount(List<Item> items) {
        if (isNull(items)) {
            return new FundAmount();
        }
        final FundAmount fundAmount = new FundAmount();
        items.forEach(item -> distributeBetweenExpenseAndIncome(item, fundAmount));
        fundAmount.currentAmount = fundAmount.income.subtract(fundAmount.expense);
        return fundAmount;
    }

    private void distributeBetweenExpenseAndIncome(Item item, FundAmount fundAmount) {
        if (isExpense(item)) {
            fundAmount.expense = fundAmount.expense.add(item.getAmount());
        } else {
            fundAmount.income = fundAmount.income.add(item.getAmount());
        }
    }

    private boolean isExpense(Item item) {
        return item.getType().equals(ItemTypeConst.EXPENSE);
    }
}
