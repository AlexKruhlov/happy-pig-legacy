package com.feature.item.transformer;

import com.feature.item.dto.ItemDto;
import com.feature.item.model.Item;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ItemTransformer {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "fundId", target = "fundId")
    })
    ItemDto toDto(Item item);

    @InheritInverseConfiguration
    Item fromDto(ItemDto itemDto);
}
