
package com.klu.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.inventory.model.Inventory;
import com.klu.inventory.repo.InventoryRepo;

@Service
public class InventoryService {

    private final InventoryRepo repo;

    public InventoryService(InventoryRepo repo) {
        this.repo = repo;
    }

    
    public Inventory addInventory(Inventory inventory) {
        return repo.save(inventory);
    }

  
    public List<Inventory> getAllInventory() {
        return repo.findAll();
    }

  
    public Inventory getInventoryById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Inventory not found: " + id));
    }

    
    public Inventory updateInventory(Long id, Inventory updated) {
        Inventory existing = getInventoryById(id);

        existing.setItemName(updated.getItemName());
        existing.setQuantity(updated.getQuantity());
        existing.setPrice(updated.getPrice());

        return repo.save(existing);
    }

   
    public void deleteInventory(Long id) {
        Inventory existing = getInventoryById(id);
        repo.delete(existing);
    }
}
