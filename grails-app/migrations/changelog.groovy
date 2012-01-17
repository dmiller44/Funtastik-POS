databaseChangeLog = {

    changeSet(author: "dmiller (generated)", id: "1326834590250-1") {
        createTable(tableName: "color") {
            column(name: "id", type: "int8") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "colorPK")
            }

            column(name: "version", type: "int8") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false", unique: "true")
            }
        }
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-2") {
        createTable(tableName: "department") {
            column(name: "id", type: "int8") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "departmentPK")
            }

            column(name: "version", type: "int8") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false", unique: "true")
            }

            column(name: "retired", type: "bool") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-3") {
        createTable(tableName: "inventory_item") {
            column(name: "id", type: "int8") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "inventory_itePK")
            }

            column(name: "version", type: "int8") {
                constraints(nullable: "false")
            }

            column(name: "archived", type: "bool") {
                constraints(nullable: "false")
            }

            column(name: "barcoded", type: "bool") {
                constraints(nullable: "false")
            }

            column(name: "color_id", type: "int8") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "varchar(255)")

            column(name: "item_type_id", type: "int8") {
                constraints(nullable: "false")
            }

            column(name: "manufacturer_id", type: "int8") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false", unique: "true")
            }

            column(name: "qoh", type: "int4") {
                constraints(nullable: "false")
            }

            column(name: "retail_price", type: "float8(19)") {
                constraints(nullable: "false")
            }

            column(name: "sku_code", type: "varchar(255)") {
                constraints(nullable: "false", unique: "true")
            }

            column(name: "sub_type_id", type: "int8")

            column(name: "taxable", type: "bool") {
                constraints(nullable: "false")
            }

            column(name: "wholesale_price", type: "float8(19)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-4") {
        createTable(tableName: "inventory_item_department") {
            column(name: "inventory_item_departments_id", type: "int8")

            column(name: "department_id", type: "int8")
        }
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-5") {
        createTable(tableName: "item_sub_type") {
            column(name: "id", type: "int8") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "item_sub_typePK")
            }

            column(name: "version", type: "int8") {
                constraints(nullable: "false")
            }

            column(name: "item_type_id", type: "int8") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "retired", type: "bool") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-6") {
        createTable(tableName: "item_type") {
            column(name: "id", type: "int8") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "item_typePK")
            }

            column(name: "version", type: "int8") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false", unique: "true")
            }

            column(name: "retired", type: "bool") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-7") {
        createTable(tableName: "manufacturer") {
            column(name: "id", type: "int8") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "manufacturerPK")
            }

            column(name: "version", type: "int8") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false", unique: "true")
            }

            column(name: "phone_number", type: "varchar(255)")

            column(name: "preferred_vendor", type: "bool") {
                constraints(nullable: "false")
            }

            column(name: "web_site", type: "varchar(255)")
        }
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-8") {
        createTable(tableName: "size") {
            column(name: "id", type: "int8") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "sizePK")
            }

            column(name: "version", type: "int8") {
                constraints(nullable: "false")
            }

            column(name: "item_type_id", type: "int8") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-9") {
        createIndex(indexName: "name_unique_1326834590190", tableName: "color", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-10") {
        createIndex(indexName: "name_unique_1326834590196", tableName: "department", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-11") {
        createIndex(indexName: "name_unique_1326834590207", tableName: "inventory_item", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-12") {
        createIndex(indexName: "sku_code_unique_1326834590209", tableName: "inventory_item", unique: "true") {
            column(name: "sku_code")
        }
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-13") {
        createIndex(indexName: "name_unique_1326834590217", tableName: "item_type", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-14") {
        createIndex(indexName: "name_unique_1326834590218", tableName: "manufacturer", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-15") {
        addForeignKeyConstraint(baseColumnNames: "color_id", baseTableName: "inventory_item", constraintName: "FKFE019416642981C6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "color", referencesUniqueColumn: "false")
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-16") {
        addForeignKeyConstraint(baseColumnNames: "item_type_id", baseTableName: "inventory_item", constraintName: "FKFE01941692D01595", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "item_type", referencesUniqueColumn: "false")
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-17") {
        addForeignKeyConstraint(baseColumnNames: "manufacturer_id", baseTableName: "inventory_item", constraintName: "FKFE0194169DC9C3AE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "manufacturer", referencesUniqueColumn: "false")
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-18") {
        addForeignKeyConstraint(baseColumnNames: "sub_type_id", baseTableName: "inventory_item", constraintName: "FKFE01941698F54634", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "item_sub_type", referencesUniqueColumn: "false")
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-19") {
        addForeignKeyConstraint(baseColumnNames: "department_id", baseTableName: "inventory_item_department", constraintName: "FKB7AABB1B25CADD0E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "department", referencesUniqueColumn: "false")
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-20") {
        addForeignKeyConstraint(baseColumnNames: "inventory_item_departments_id", baseTableName: "inventory_item_department", constraintName: "FKB7AABB1B125C2B7D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "inventory_item", referencesUniqueColumn: "false")
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-21") {
        addForeignKeyConstraint(baseColumnNames: "item_type_id", baseTableName: "item_sub_type", constraintName: "FK9B2DED8592D01595", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "item_type", referencesUniqueColumn: "false")
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-22") {
        addForeignKeyConstraint(baseColumnNames: "item_type_id", baseTableName: "size", constraintName: "FK35E00192D01595", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "item_type", referencesUniqueColumn: "false")
    }

    changeSet(author: "dmiller (generated)", id: "1326834590250-23") {
        createSequence(sequenceName: "hibernate_sequence")
    }
}
