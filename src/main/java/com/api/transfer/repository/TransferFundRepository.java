package com.api.transfer.repository;

import com.feature.transfer.model.TransferFund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Provides the data access layer API to work on transfer fund objects
 **/
public interface TransferFundRepository extends JpaRepository<TransferFund, String> {

    List<TransferFund> findByIdFundId(String fundId);
}
