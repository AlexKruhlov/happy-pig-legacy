package com.feature.transfer.transformer;

import com.feature.transfer.dto.TransferFundDto;
import com.feature.transfer.model.TransferFund;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Transforms transfer fund objects into dto and back
 */
@Mapper
public interface TransferFundTransformer {

    @Mappings({
            @Mapping(source = "id.fundId", target = "fundId"),
            @Mapping(source = "id.transfer", target = "transfer")
    })
    TransferFundDto toDto(TransferFund transferFund);

    @InheritInverseConfiguration
    TransferFund fromDto(TransferFundDto transferFundDto);
}
