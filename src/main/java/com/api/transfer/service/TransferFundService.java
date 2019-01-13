package com.api.transfer.service;

import com.feature.transfer.dto.TransferFundDto;
import com.feature.transfer.model.TransferFund;

import java.util.List;

/**
 * Provides service layer API to work with {@link TransferFund} objects
 */
public interface TransferFundService {

    /**
     * Finds transfer funds by fund id, maps into dto and returns them
     *
     * @param fundId fund id
     * @return list of tranfer fund dto
     * @see TransferFundDto
     */
    List<TransferFundDto> findByFundId(String fundId);
}
