package com.feature.transfer.transformer;

import com.feature.transfer.dto.TransferDto;
import com.feature.transfer.model.Transfer;
import org.mapstruct.Mapper;

@Mapper
public interface TransferTransformer {

    TransferDto toDto(Transfer transfer);

    Transfer fromDto(TransferDto transferDto);
}
