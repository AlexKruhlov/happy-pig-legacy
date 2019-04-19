package com.feature.utils;

import com.feature.bank.bankincome.dto.BankIncomeDto;
import com.feature.bank.bankincomesource.dto.BankIncomeSourceDto;
import com.feature.bank.banktransaction.dto.BankTransactionDto;
import com.feature.bank.banktransaction.model.BankTransactionType;
import com.feature.fund.dto.FundDto;
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
    public static String INCORRECT_ID = "INCORRECT_ID";

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

    public static String POTATO_PRODUCT_POSITION_ID = "POTATO_SPEC";
    public static String BALL_PRODUCT_POSITION_ID = "BALL_SPEC_1";

    public static String GROCERY_TO_RENTAL_TR_FUND_ID = "GROCERY_TO_RENTAL";

    public static String TRANSFER_ID = "TRANSFER_ID";

    public static String BANK_INCOME_SOURCE_ID = "SALARY";

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

    public static ItemDto createItemDto() {
        return ItemDto.builder()
                .id(ITEM_ID)
                .amount("50")
                .cost("100000")
                .type(INCOME)
                .date(now())
                .fundId(GROCERY_FUND)
                .productPositionId(POTATO_PRODUCT_POSITION_ID)
                .unit(PC_UNIT_DTO)
                .comment("POTATO comments").build();
    }

    public static ProductPositionDto createProductPositionDto() {
        return ProductPositionDto.builder()
                .id(BALL_PRODUCT_POSITION_ID)
                .specification("BALL spec")
                .product(BALL_PRODUCT_DTO).build();
    }


    public static final BankIncomeSourceDto BANK_INCOME_SOURCE_SALARY = BankIncomeSourceDto.builder()
            .id("SALARY")
            .name("Salary").build();
    public static final String BANK_INCOME_SALARY_ID = "BANK_INCOME_SALARY";
    public static final String BANK_INCOME_SALARY_AMOUNT = "500000";
    public static final int ALL_BANK_INCOMES_COUNT = 3;


    public static BankIncomeDto createBankIncomeDto(String id, String amount, BankIncomeSourceDto bankIncomeSourceDto) {
        return BankIncomeDto.builder()
                .id(id)
                .amount(amount)
                .bankIncomeSource(bankIncomeSourceDto).build();
    }

    public static final int BANK_TRANSACTIONS_COUNT = 3;
    public static final String BANK_TRANSACTION_GROCERY_FUND = "BANK_TRANSACTION_GROCERY_FUND";

    public static BankTransactionDto createBankTransactionDto(String id, BankTransactionType type, String amount, String fundId) {
        return BankTransactionDto.builder()
                .id(id)
                .amount(amount)
                .bankTransactionType(type)
                .fund(FundDto.builder().id(fundId).build()).build();
    }

    public static final BigInteger BANK_INCOMES_BANK_TRANSACTION_RESIDUAL = BigInteger.valueOf(589549L);
}
