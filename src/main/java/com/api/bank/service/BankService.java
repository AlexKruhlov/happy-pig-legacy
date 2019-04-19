package com.api.bank.service;

import com.feature.bank.model.Bank;

/**
 * Interface that provides service layer API to work on {@link Bank} object
 */
public interface BankService {

    /**
     * Form {@link Bank} object and return it
     *
     * @return {@link Bank} object
     */
    Bank getBank();
}
