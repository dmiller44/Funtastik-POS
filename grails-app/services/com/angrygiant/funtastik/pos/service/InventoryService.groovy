package com.angrygiant.funtastik.pos.service

import com.angrygiant.funtastik.pos.domain.Color
import com.angrygiant.funtastik.pos.domain.InventoryItem
import com.angrygiant.funtastik.pos.domain.InventoryItemRecord
import com.angrygiant.funtastik.pos.domain.ItemType
import com.angrygiant.funtastik.pos.domain.Manufacturer

class InventoryService {

    int getTotalQuantityOnHand(InventoryItem inventoryItem) {
        return InventoryItemRecord.withCriteria {
            projections {
                sum('qoh')
            }
            eq("inventoryItem", inventoryItem)
        }.get(0)
    }

    boolean haveColorsBeenUsed(Color color) {
        return InventoryItem.findAllByColor(color).size() > 0
    }

    boolean haveManufacturersBeenUsed(Manufacturer manufacturer) {
        return InventoryItem.findAllByManufacturer(manufacturer).size() > 0
    }

    boolean haveItemTypesBeenUsed(ItemType itemType) {
        return InventoryItem.findAllByItemType(itemType).size() > 0
    }
}