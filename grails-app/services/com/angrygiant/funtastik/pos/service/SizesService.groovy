package com.angrygiant.funtastik.pos.service

import com.angrygiant.funtastik.pos.domain.InventoryItemRecord
import com.angrygiant.funtastik.pos.domain.Size

class SizesService {

    def getAvailableSizesForItem(Long inventoryId, Long itemTypeId) {
        return Size.executeQuery("FROM Size as size WHERE size.id NOT IN (SELECT record.size.id FROM InventoryItemRecord record WHERE record.inventoryItem.id = ${inventoryId}) AND size.itemType.id = ${itemTypeId}")
    }

    def getSizesForItem(Long inventoryId, Long itemTypeId) {
        return Size.executeQuery("FROM Size as size WHERE size.id IN (SELECT record.size.id FROM InventoryItemRecord record WHERE record.inventoryItem.id = ${inventoryId}) AND size.itemType.id = ${itemTypeId}")
    }

    def hasSizesUsed(Size size) {
        return InventoryItemRecord.findAllBySize(size).size() > 0
    }
}
