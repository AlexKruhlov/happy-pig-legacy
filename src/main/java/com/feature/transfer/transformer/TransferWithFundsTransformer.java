package com.feature.transfer.transformer;

import com.feature.transfer.dto.TransferWithFundsDto;
import com.feature.transfer.model.Transfer;
import com.feature.transfer.model.TransferFund;
import com.feature.transfer.model.TransferFundId;
import org.mapstruct.Mapper;

import java.math.BigInteger;
import java.util.ArrayList;

import static com.feature.transfer.model.TransferType.INCOME;
import static com.feature.transfer.model.TransferType.OUTCOME;

/**
 * Transforms transfer object into dto with appropriate fund ids and back
 */
@Mapper
public interface TransferWithFundsTransformer {

    default TransferWithFundsDto toDto(Transfer transfer) {
        return TransferWithFundsDto.builder()
                .id(transfer.getId())
                .fromFundId(transfer.getTransferFundByType(OUTCOME).getId().getFundId())
                .toFundId(transfer.getTransferFundByType(INCOME).getId().getFundId())
                .sum(transfer.getSum().toString())
                .date(transfer.getDate())
                .build();
    }

    default Transfer fromDto(TransferWithFundsDto transferWithFundsDto) {
        Transfer transfer = Transfer.builder()
                .id(transferWithFundsDto.getId())
                .sum(new BigInteger(transferWithFundsDto.getSum()))
                .date(transferWithFundsDto.getDate())
                .build();
        transfer.setTransferFunds(new ArrayList<>());
        transfer.getTransferFunds()
                .add(new TransferFund(new TransferFundId(transferWithFundsDto.getFromFundId(), transfer), OUTCOME));
        transfer.getTransferFunds()
                .add(new TransferFund(new TransferFundId(transferWithFundsDto.getToFundId(), transfer), INCOME));
        return transfer;
    }
}
