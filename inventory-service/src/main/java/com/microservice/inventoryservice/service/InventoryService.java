package com.microservice.inventoryservice.service;

import com.microservice.inventoryservice.dto.InventoryResponse;
import com.microservice.inventoryservice.model.Inventory;
import com.microservice.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCodes) {
        return inventoryRepository.findBySkuCodeIn(skuCodes).stream().map(this::inventoryToResponseConverter).toList();
    }

    public InventoryResponse inventoryToResponseConverter(Inventory inventory) {
        return InventoryResponse.builder().skuCode(inventory.getSkuCode()).isInStock(inventory.getQuantity() > 0).build();
    }
}
