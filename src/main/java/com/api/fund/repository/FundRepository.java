package com.api.fund.repository;

import com.feature.fund.model.Fund;
import org.springframework.data.repository.CrudRepository;

public interface FundRepository extends CrudRepository<Fund, String> {
}