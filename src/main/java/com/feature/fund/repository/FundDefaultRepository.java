package com.feature.fund.repository;

import com.feature.fund.model.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundDefaultRepository extends JpaRepository<Fund, String> {
}
