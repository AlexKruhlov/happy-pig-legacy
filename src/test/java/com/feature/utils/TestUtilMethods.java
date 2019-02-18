package com.feature.utils;

import com.feature.prodposition.dto.ProductPositionDto;
import com.feature.product.dto.ProductDto;
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

    public static String PC_UNIT_ID = "pc";
    public static UnitDto PC_UNIT_DTO = UnitDto.builder()
            .id(PC_UNIT_ID)
            .name("peaces").build();

    public static String BALL_PRODUCT_ID = "BALL";
    public static ProductDto BALL_PRODUCT_DTO = ProductDto.builder()
            .id(BALL_PRODUCT_ID)
            .name("Ball")
            .defaultUnit(PC_UNIT_DTO).build();

    public static String BALL_PRODUCT_POSITION_ID = "BALL_SPEC";
    public static ProductPositionDto BALL_PRODUCT_POSITION_DTO = ProductPositionDto.builder()
            .id(BALL_PRODUCT_POSITION_ID)
            .specification("BALL spec")
            .product(BALL_PRODUCT_DTO).build();

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
