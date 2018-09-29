package com.api.statistic.service;

import com.feature.statistic.model.FundStatistic;

/**
 * Provides possibility of working on statistics business logic
 */
public interface StatisticService {

    /**
     * Forms and return fund statistics
     *
     * @return fund statistics
     * @see FundStatistic
     */
    FundStatistic createStatistic();
}
