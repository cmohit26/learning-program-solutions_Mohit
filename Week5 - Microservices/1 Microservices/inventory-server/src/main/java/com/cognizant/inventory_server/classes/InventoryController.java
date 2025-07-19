package com.cognizant.inventory_server.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductClient productClient;

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        // Validate product exists
        Product product = productClient.getProductById(stock.getProductId());
        return stockRepository.save(stock);
    }

    @GetMapping("/with-product/{id}")
    public ResponseEntity<?> getStockWithProduct(@PathVariable Long id) {
        return stockRepository.findById(id)
                .map(stock -> {
                    Product product = productClient.getProductById(stock.getProductId());
                    Map<String, Object> map = new HashMap<>();
                    map.put("stock", stock);
                    map.put("product", product);
                    return ResponseEntity.ok(map);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

