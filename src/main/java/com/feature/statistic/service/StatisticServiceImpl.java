package com.feature.statistic.service;

import com.api.fund.service.FundService;
import com.api.statistic.service.StatisticService;
import com.feature.fund.dto.FundDto;
import com.feature.statistic.model.FundStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {
    private FundService fundService;

    @Autowired
    public StatisticServiceImpl(FundService fundService) {
        this.fundService = fundService;
    }

    @Override
    public FundStatistic createStatistic() {
        FundStatistic fundStatistic = new FundStatistic();
        fundStatistic.setFunds(fundService.findAll());
        fundStatistic.setTotal(calculateTotal(fundStatistic.getFunds()).toString());
        return fundStatistic;
    }

    private BigInteger calculateTotal(List<FundDto> funds) {
        return funds.stream()
                .map(this::getAmount)
                .reduce(this::sum)
                .orElse(BigInteger.ZERO);
    }

    private BigInteger getAmount(FundDto fundDto) {
        return new BigInteger(fundDto.getAmount());
    }

    private BigInteger sum(BigInteger bigInteger1, BigInteger bigInteger2) {
        return bigInteger1.add(bigInteger2);
    }
}
