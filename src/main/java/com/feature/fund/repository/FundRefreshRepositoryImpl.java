package com.feature.fund.repository;

import com.api.fund.repository.FundRefreshRepository;
import com.feature.fund.model.Fund;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FundRefreshRepositoryImpl implements FundRefreshRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void refresh(Fund fund) {
        entityManager.refresh(fund);
    }
}
