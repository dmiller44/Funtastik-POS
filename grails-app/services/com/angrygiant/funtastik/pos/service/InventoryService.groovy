package com.angrygiant.funtastik.pos.service

import com.angrygiant.funtastik.pos.domain.InventoryItem
import com.angrygiant.funtastik.pos.domain.InventoryItemRecord

class InventoryService {

    int getTotalQuantityOnHand(InventoryItem inventoryItem) {
        return InventoryItemRecord.withCriteria {
            projections {
                sum('qoh')
            }
            eq("inventoryItem", inventoryItem)
        }.get(0)
    }
}
