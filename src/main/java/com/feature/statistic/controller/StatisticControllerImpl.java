package com.feature.statistic.controller;

import com.api.statistic.controller.StatisticController;
import com.api.statistic.service.StatisticService;
import com.feature.statistic.model.FundStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic")
public class StatisticControllerImpl implements StatisticController {
    private StatisticService statisticService;

    @Autowired
    public StatisticControllerImpl(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @Override
    @GetMapping("/create")
    public FundStatistic createStatistic() {
        return statisticService.createStatistic();
    }
}
