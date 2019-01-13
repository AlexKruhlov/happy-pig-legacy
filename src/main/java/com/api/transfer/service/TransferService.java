package com.api.transfer.service;

import com.feature.transfer.dto.TransferWithFundsDto;
import com.feature.transfer.model.Transfer;

import java.util.List;

/**
 * Provides service layer API to work with {@link Transfer} objects
 */
public interface TransferService {

    /**
     * Finds all transfers, transforms into dto an returns them
     *
     * @return list of transfer dtos
     * @see Transfer
     * @see TransferWithFundsDto
     */
    List<TransferWithFundsDto> findAll();

    /**
     * Transforms transferWithFundsDto to transfer, saves and returns saved transfer object
     *
     * @param transferWithFundsDto transfer dto
     * @return saved transfer object
     * @see Transfer
     * @see TransferWithFundsDto
     */
    TransferWithFundsDto save(TransferWithFundsDto transferWithFundsDto);
}
