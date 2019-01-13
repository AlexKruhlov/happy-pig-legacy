package com.feature.transfer.service;

import com.api.transfer.repository.TransferFundRepository;
import com.feature.transfer.dto.TransferDto;
import com.feature.transfer.dto.TransferFundDto;
import com.feature.transfer.model.Transfer;
import com.feature.transfer.model.TransferFund;
import com.feature.transfer.model.TransferFundId;
import com.feature.transfer.transformer.TransferFundTransformer;
import com.feature.transfer.transformer.TransferFundTransformerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.feature.transfer.model.TransferType.*;
import static com.feature.transfer.model.TransferType.INCOME;
import static com.feature.utils.TestUtilMethods.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TransferFundServiceUnitTest {

    @Mock
    private TransferFundRepository transferFundRepository;

    @Spy
    private final TransferFundTransformer transferFundTransformer = new TransferFundTransformerImpl();

    @InjectMocks
    private TransferFundServiceImpl transferFundService;

    @Test
    public void shouldTransformTransferFundIntoTransferFundDto() {
        final String transferSum = "596";
        Transfer transfer = Transfer.builder()
                .id(TRANSFER_ID)
                .sum(new BigInteger(transferSum)).build();
        List<TransferFund> transferFunds = new ArrayList<>();
        transferFunds.add(new TransferFund(new TransferFundId(GROCERY_FUND, transfer), OUTCOME));
        transferFunds.add(new TransferFund(new TransferFundId(DRESS_FUND, transfer), INCOME));
        transfer.setTransferFunds(transferFunds);

        TransferFund inutedTransferFund = transfer.getTransferFundByType(OUTCOME);
        TransferFundDto transferFundDto = transferFundTransformer.toDto(inutedTransferFund);
        assertEquals(GROCERY_FUND, transferFundDto.getFundId());
        assertEquals(OUTCOME, transferFundDto.getTransferType());
        assertEquals(transfer.getId(), transferFundDto.getTransfer().getId());
    }

    @Test
    public void shouldTransformTransferFundDtoIntoTransferFund() {
        final String transferSum = "897";
        TransferFundDto transferFundDto = TransferFundDto.builder()
                .fundId(GROCERY_FUND)
                .transferType(OUTCOME)
                .transfer(new TransferDto(TRANSFER_ID, transferSum, null)).build();

        TransferFund transferFund = transferFundTransformer.fromDto(transferFundDto);
        assertEquals(transferFund.getId().getFundId(), GROCERY_FUND);
        assertEquals(transferFund.getId().getTransfer().getId(), TRANSFER_ID);
        assertEquals(transferFund.getId().getTransfer().getSum(), new BigInteger(transferSum));
        assertEquals(OUTCOME, transferFund.getTransferType());

    }
}
