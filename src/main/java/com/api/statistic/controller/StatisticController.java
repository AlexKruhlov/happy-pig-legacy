package com.api.statistic.controller;

import com.feature.statistic.model.FundStatistic;

/**
 * Provides the endpoints to work on statistics
 */
public interface StatisticController {

    /**
     * Forms the statistic information about all funds
     *
     * @return fund statistic
     * @see FundStatistic
     */
    FundStatistic createStatistic();
}
