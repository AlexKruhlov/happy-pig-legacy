package com.feature.fund.repository;

import com.feature.fund.model.Fund;
import org.springframework.data.repository.CrudRepository;

public interface FundDefaultRepository extends CrudRepository<Fund, String> {
}
