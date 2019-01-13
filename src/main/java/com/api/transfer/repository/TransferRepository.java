package com.api.transfer.repository;

import com.feature.transfer.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides the data access layer API to work on transfer objects
 */
public interface TransferRepository extends JpaRepository<Transfer, String> {
}
