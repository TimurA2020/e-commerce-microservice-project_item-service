package com.microserviceproject.productservice.service;

import com.microserviceproject.productservice.dto.ItemDto;
import com.microserviceproject.productservice.mappers.ItemMapper;
import com.microserviceproject.productservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;

    public void createProduct(ItemDto itemDto) {
        itemRepository.save(itemMapper.toItemEntity(itemDto));
        log.info("Product {} has been saved successfully ", itemDto.getTitle());
    }

    public List<ItemDto> getAllItems() {
        return itemMapper.toItemDtoList(itemRepository.findAll());
    }
}
