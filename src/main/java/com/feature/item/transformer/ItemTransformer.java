package com.feature.item.transformer;

import com.feature.item.dto.ItemDto;
import com.feature.item.model.Item;
import com.feature.product.transformer.ProductTransformer;
import org.mapstruct.*;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(uses = ProductTransformer.class, injectionStrategy = CONSTRUCTOR)
public interface ItemTransformer {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "cost", target = "cost"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "fundId", target = "fundId"),
            @Mapping(source = "product", target = "product")
    })
    ItemDto toDto(Item item);

    @InheritInverseConfiguration
    Item fromDto(ItemDto itemDto);
}
