package com.api.transfer.component;

import com.feature.transfer.dto.TransferWithFundsDto;
import com.feature.transfer.model.Transfer;

import java.util.List;

/**
 * Provides API for UI to work with {@link Transfer} objects
 */
public interface TransferComponent {

    /**
     * Finds all transfer dtos
     *
     * @return list of transfer dtos
     * @see TransferWithFundsDto
     */
    List<TransferWithFundsDto> findAll();

    /**
     * Saves and returns saved transfer object
     *
     * @param transferWithFundsDto transfer dto
     * @return saved transfer object
     * @see TransferWithFundsDto
     */
    TransferWithFundsDto create(TransferWithFundsDto transferWithFundsDto);
}
