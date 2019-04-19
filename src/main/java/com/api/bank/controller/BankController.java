package com.api.bank.controller;

import com.feature.bank.dto.BankDto;

/**
 * Interface that provides API for UI to work on {@link BankDto} object
 */
public interface BankController {

    /**
     * Get {@link BankDto} object
     *
     * @return {@link BankDto}
     */
    BankDto getBank();
}
