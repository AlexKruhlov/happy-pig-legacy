package com.api.fund.repository;

import com.feature.fund.model.Fund;

public interface FundRefreshRepository {

    void refresh(Fund fund);
}
