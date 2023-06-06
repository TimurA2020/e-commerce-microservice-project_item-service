package com.microserviceproject.productservice.mappers;

import com.microserviceproject.productservice.document.Item;
import com.microserviceproject.productservice.dto.ItemDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item toItemEntity(ItemDto itemDto);

    List<ItemDto> toItemDtoList(List<Item> items);
}
