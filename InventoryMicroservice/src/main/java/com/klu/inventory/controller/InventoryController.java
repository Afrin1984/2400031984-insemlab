
package com.klu.inventory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.inventory.model.Inventory;
import com.klu.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return service.addInventory(inventory);
    }

    @GetMapping
    public List<Inventory> getAllInventory() {
        return service.getAllInventory();
    }

    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable Long id) {
        return service.getInventoryById(id);
    }

    @PutMapping("/{id}")
    public Inventory updateInventory(
            @PathVariable Long id,
            @RequestBody Inventory inventory) {
        return service.updateInventory(id, inventory);
    }

    @DeleteMapping("/{id}")
    public String deleteInventory(@PathVariable Long id) {
        service.deleteInventory(id);
        return "Inventory deleted successfully";
    }
}
