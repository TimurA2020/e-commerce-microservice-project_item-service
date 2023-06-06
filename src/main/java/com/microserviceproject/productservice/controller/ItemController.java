package com.microserviceproject.productservice.controller;

import com.microserviceproject.productservice.dto.ItemDto;
import com.microserviceproject.productservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ItemDto itemDto) {
        itemService.createProduct(itemDto);
    }
}
