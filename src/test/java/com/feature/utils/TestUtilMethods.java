package com.feature.utils;

import com.feature.transfer.model.Transfer;
import com.feature.transfer.model.TransferFund;
import com.feature.transfer.model.TransferFundId;
import com.feature.transfer.model.TransferType;
import com.feature.unit.dto.UnitDto;

import java.math.BigInteger;

public class TestUtilMethods {
    public static String GROCERY_FUND = "GROCERY_FUND";
    public static String RENTAL_FUND = "RENTAL_FUND";
    public static String DRESS_FUND = "DRESS_FUND";

    public static UnitDto KG_UNIT_DTO = UnitDto.builder().id("kg").name("kilogram").build();

    public static String GROCERY_TO_RENTAL_TRFUND_ID = "GROCERY_TO_RENTAL";

    public static String TRANSFER_ID = "TRANSFER_ID";

    public static TransferFund createTransferFund(String transferId, String fundId, TransferType transferType, long sum) {
        Transfer transfer = Transfer.builder()
                .id(transferId)
                .sum(BigInteger.valueOf(sum))
                .build();
        return TransferFund.builder()
                .id(new TransferFundId(fundId, transfer))
                .transferType(transferType)
                .build();
    }
}
