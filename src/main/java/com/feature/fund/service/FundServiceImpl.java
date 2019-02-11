package com.feature.fund.service;

import com.api.fund.repository.FundRepository;
import com.api.fund.service.FundService;
import com.feature.fund.dto.FundDto;
import com.feature.fund.dto.FundDtoWithItemsAndTransferFunds;
import com.feature.fund.model.Fund;
import com.feature.fund.transformer.FundTransformer;
import com.feature.item.model.Item;
import com.feature.item.model.ItemTypeConst;
import com.feature.transfer.model.TransferFund;
import com.feature.transfer.model.TransferType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Implements possibility of working on fund business logic
 */
@Service
public class FundServiceImpl implements FundService {

    private final class FundAmount {
        private BigInteger currentAmount = BigInteger.ZERO;
        private BigInteger income = BigInteger.ZERO;
        private BigInteger expense = BigInteger.ZERO;
        private BigInteger transferIncome = BigInteger.ZERO;
        private BigInteger transferOutcome = BigInteger.ZERO;
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
    public FundDtoWithItemsAndTransferFunds findById(String id) {
        Fund fund = addAmount(fundRepository.findById(id).orElse(null));
        return fundTransformer.toDtoWithItemsAndTransferFunds(fund);
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
    public FundDtoWithItemsAndTransferFunds update(FundDtoWithItemsAndTransferFunds fundDtoWithItemsAndTransferFunds) {
        Fund savedFund = fundRepository.save(fundTransformer.fromDtoWithItemsAndTransferFunds(fundDtoWithItemsAndTransferFunds));
        Fund savedFundWithAmounts = addAmount(savedFund);
        return fundTransformer.toDtoWithItemsAndTransferFunds(savedFundWithAmounts);
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
    public List<FundDto> deleteByIdAndFindAll(String id) {
        fundRepository.deleteById(id);
        return findAll();
    }

    private Fund addAmount(Fund fund) {
        if (isNull(fund)) {
            return null;
        }
        FundAmount fundAmount = calculateAmount(fund.getItems(), fund.getTransferFunds());
        fund.setAmount(fundAmount.currentAmount);
        fund.setExpense(fundAmount.expense);
        fund.setIncome(fundAmount.income);
        return fund;
    }

    private FundAmount calculateAmount(List<Item> items, List<TransferFund> transferFunds) {
        final FundAmount fundAmount = new FundAmount();
        if (nonEmpty(items)) {
            items.forEach(item -> distributeItemAmounts(item, fundAmount));
            fundAmount.currentAmount = fundAmount.income.subtract(fundAmount.expense);
        }
        if (nonEmpty(transferFunds)) {
            transferFunds.forEach(transferFund -> distributeTransferSums(transferFund, fundAmount));
            fundAmount.currentAmount =
                    fundAmount.currentAmount.add(fundAmount.transferIncome.subtract(fundAmount.transferOutcome));
        }
        return fundAmount;
    }

    private void distributeItemAmounts(Item item, FundAmount fundAmount) {
        if (isExpense(item)) {
            fundAmount.expense = fundAmount.expense.add(item.getCost());
        } else {
            fundAmount.income = fundAmount.income.add(item.getCost());
        }
    }

    private void distributeTransferSums(TransferFund transferFund, FundAmount fundAmount) {
        if (transferFund.getTransferType().equals(TransferType.INCOME)) {
            fundAmount.transferIncome = fundAmount.transferIncome.add(transferFund.getId().getTransfer().getSum());
        } else {
            fundAmount.transferOutcome = fundAmount.transferOutcome.add(transferFund.getId().getTransfer().getSum());
        }
    }

    private boolean isExpense(Item item) {
        return item.getType().equals(ItemTypeConst.EXPENSE);
    }

    private boolean nonEmpty(List list) {
        return nonNull(list) && !list.isEmpty();
    }
}
