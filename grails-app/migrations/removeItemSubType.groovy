databaseChangeLog = {

    changeSet(author: "dmiller (generated)", id: "1329273945151-1") {
        dropForeignKeyConstraint(baseTableName: "inventory_item", baseTableSchemaName: "public", constraintName: "fkfe01941698f54634")
    }

    changeSet(author: "dmiller (generated)", id: "1329273945151-2") {
        dropForeignKeyConstraint(baseTableName: "item_sub_type", baseTableSchemaName: "public", constraintName: "fk9b2ded8592d01595")
    }

    changeSet(author: "dmiller (generated)", id: "1329273945151-3") {
        dropColumn(columnName: "sub_type_id", tableName: "inventory_item")
    }

    changeSet(author: "dmiller (generated)", id: "1329273945151-4") {
        dropTable(tableName: "item_sub_type")
    }
}
