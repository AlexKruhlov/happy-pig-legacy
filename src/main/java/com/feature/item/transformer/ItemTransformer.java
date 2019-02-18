package com.feature.item.transformer;

import com.feature.item.dto.ItemDto;
import com.feature.item.model.Item;
import com.feature.prodposition.transformer.ProductPositionTransformer;
import org.mapstruct.*;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(uses = {ProductPositionTransformer.class}, injectionStrategy = CONSTRUCTOR)
public interface ItemTransformer {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "cost", target = "cost"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "fundId", target = "fundId"),
            @Mapping(source = "productPositionId", target = "productPositionId"),
            @Mapping(source = "productPosition", target = "productPosition"),
            @Mapping(source = "unitId", target = "unitId"),
            @Mapping(source = "comment", target = "comment")
    })
    ItemDto toDto(Item item);

    @InheritInverseConfiguration
    Item fromDto(ItemDto itemDto);
}
