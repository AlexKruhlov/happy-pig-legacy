package com.api.fund.repository;

import com.feature.fund.model.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRepository extends JpaRepository<Fund, String> {
}
