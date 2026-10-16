
package com.klu.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.inventory.model.Inventory;

public interface InventoryRepo
        extends JpaRepository<Inventory, Long> {
}
