package com.api.fund.repository;

import com.feature.fund.model.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides the repository methods to work on funds
 */
public interface FundRepository extends JpaRepository<Fund, String> {
}
