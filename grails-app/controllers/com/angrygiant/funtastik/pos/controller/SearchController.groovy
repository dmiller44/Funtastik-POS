package com.angrygiant.funtastik.pos.controller

import com.angrygiant.funtastik.pos.domain.InventoryItem

class SearchController {

    def inventorySearch() {
        String templateName = "/inventory/side-navigation-admin"

        if (params.id == "cashRegister") {
            templateName = "/cashRegister/side-navigation"
        }

        [templateName: templateName]
    }

    def searchInventory() {
        def results = InventoryItem.findAllBySkuCodeIlike("%${params.q}%")

        results.addAll(InventoryItem.findAllByNameIlike("%${params.q}%"))
        results.addAll(InventoryItem.findAllByDescriptionIlikeAndNameNotIlike("%${params.q}%", "%${params.q}%"))

        render(view: 'searchResults', model: [results: results, templateName: params.templateName])
    }
}
