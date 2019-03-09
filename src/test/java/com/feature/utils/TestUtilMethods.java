package com.feature.utils;

import com.feature.item.dto.ItemDto;
import com.feature.prodposition.dto.ProductPositionDto;
import com.feature.product.dto.ProductDto;
import com.feature.transfer.model.Transfer;
import com.feature.transfer.model.TransferFund;
import com.feature.transfer.model.TransferFundId;
import com.feature.transfer.model.TransferType;
import com.feature.unit.dto.UnitDto;

import java.math.BigInteger;

import static com.feature.item.model.ItemTypeConst.INCOME;
import static java.time.LocalDateTime.now;

public class TestUtilMethods {
    public static String GROCERY_FUND = "GROCERY_FUND";
    public static String RENTAL_FUND = "RENTAL_FUND";
    public static String DRESS_FUND = "DRESS_FUND";

    public static String PC_UNIT_ID = "pc";
    public static String KG_UNIT_ID = "kg";
    public static UnitDto PC_UNIT_DTO = UnitDto.builder().id(PC_UNIT_ID).name("peaces").build();
    public static UnitDto KG_UNIT_DTO = UnitDto.builder().id(KG_UNIT_ID).name("kilogram").build();

    public static String PIPE_PRODUCT_ID = "PIPE";
    public static String BALL_PRODUCT_ID = "BALL";
    public static ProductDto BALL_PRODUCT_DTO = ProductDto.builder()
            .id(BALL_PRODUCT_ID)
            .name("Ball")
            .defaultUnit(PC_UNIT_DTO).build();

    public static String POTATOE_PRODUCT_POSITION_ID = "POTATO_SPEC";
    public static String BALL_PRODUCT_POSITION_ID = "BALL_SPEC_1";
    public static ProductPositionDto BALL_PRODUCT_POSITION_DTO = ProductPositionDto.builder()
            .id(BALL_PRODUCT_POSITION_ID)
            .specification("BALL spec")
            .product(BALL_PRODUCT_DTO).build();

    public static String GROCERY_TO_RENTAL_TRFUND_ID = "GROCERY_TO_RENTAL";

    public static String TRANSFER_ID = "TRANSFER_ID";

    public static String ITEM_ID = "ITEM_0000001";

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

    public static ItemDto createItemDto(){
        return ItemDto.builder()
                .id(ITEM_ID)
                .amount("50")
                .cost("100000")
                .type(INCOME)
                .date(now())
                .fundId(GROCERY_FUND)
                .productPositionId(POTATOE_PRODUCT_POSITION_ID)
                .unit(PC_UNIT_DTO)
                .comment("POTATO comments").build();
    }
}
