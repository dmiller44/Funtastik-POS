databaseChangeLog = {

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-1") {
        createTable(tableName: "color") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "colorPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false", unique: "true")
            }
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-2") {
        createTable(tableName: "department") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "departmentPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false", unique: "true")
            }

            column(name: "retired", type: "bit") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-3") {
        createTable(tableName: "inventory_item") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "inventory_itePK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "archived", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "barcoded", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "color_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "create_date", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "created_by", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "varchar(255)")

            column(name: "item_type_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "manufacturer_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false", unique: "true")
            }

            column(name: "qoh", type: "integer") {
                constraints(nullable: "false")
            }

            column(name: "retail_price", type: "float(19,2)") {
                constraints(nullable: "false")
            }

            column(name: "sku_code", type: "varchar(255)") {
                constraints(nullable: "false", unique: "true")
            }

            column(name: "taxable", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "updated_by", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "updated_date", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "wholesale_price", type: "float(19,2)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-4") {
        createTable(tableName: "inventory_item_department") {
            column(name: "inventory_item_departments_id", type: "bigint")

            column(name: "department_id", type: "bigint")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-5") {
        createTable(tableName: "item_type") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "item_typePK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false", unique: "true")
            }

            column(name: "retired", type: "bit") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-6") {
        createTable(tableName: "manufacturer") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "manufacturerPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false", unique: "true")
            }

            column(name: "phone_number", type: "varchar(255)")

            column(name: "preferred_vendor", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "web_site", type: "varchar(255)")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-7") {
        createTable(tableName: "role") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "authority", type: "varchar(255)") {
                constraints(nullable: "false", unique: "true")
            }
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-8") {
        createTable(tableName: "size") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "sizePK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "item_type_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-9") {
        createTable(tableName: "user_role") {
            column(name: "role_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-10") {
        createTable(tableName: "users") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usersPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "account_expired", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "account_locked", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "enabled", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "password", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "password_expired", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "username", type: "varchar(255)") {
                constraints(nullable: "false", unique: "true")
            }
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-11") {
        addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-12") {
        createIndex(indexName: "name_unique_1356115251852", tableName: "color", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-13") {
        createIndex(indexName: "name_unique_1356115251857", tableName: "department", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-14") {
        createIndex(indexName: "FKFE019416642981C6", tableName: "inventory_item") {
            column(name: "color_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-15") {
        createIndex(indexName: "FKFE01941692D01595", tableName: "inventory_item") {
            column(name: "item_type_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-16") {
        createIndex(indexName: "FKFE0194169DC9C3AE", tableName: "inventory_item") {
            column(name: "manufacturer_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-17") {
        createIndex(indexName: "name_unique_1356115251867", tableName: "inventory_item", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-18") {
        createIndex(indexName: "sku_code_unique_1356115251868", tableName: "inventory_item", unique: "true") {
            column(name: "sku_code")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-19") {
        createIndex(indexName: "FKB7AABB1B125C2B7D", tableName: "inventory_item_department") {
            column(name: "inventory_item_departments_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-20") {
        createIndex(indexName: "FKB7AABB1B25CADD0E", tableName: "inventory_item_department") {
            column(name: "department_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-21") {
        createIndex(indexName: "name_unique_1356115251873", tableName: "item_type", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-22") {
        createIndex(indexName: "name_unique_1356115251874", tableName: "manufacturer", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-23") {
        createIndex(indexName: "authority_unique_1356115251876", tableName: "role", unique: "true") {
            column(name: "authority")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-24") {
        createIndex(indexName: "FK35E00192D01595", tableName: "size") {
            column(name: "item_type_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-25") {
        createIndex(indexName: "FK143BF46A61680625", tableName: "user_role") {
            column(name: "user_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-26") {
        createIndex(indexName: "FK143BF46AE1E0122C", tableName: "user_role") {
            column(name: "role_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-27") {
        createIndex(indexName: "username_unique_1356115251881", tableName: "users", unique: "true") {
            column(name: "username")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-28") {
        addForeignKeyConstraint(baseColumnNames: "color_id", baseTableName: "inventory_item", constraintName: "FKFE019416642981C6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "color", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-29") {
        addForeignKeyConstraint(baseColumnNames: "item_type_id", baseTableName: "inventory_item", constraintName: "FKFE01941692D01595", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "item_type", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-30") {
        addForeignKeyConstraint(baseColumnNames: "manufacturer_id", baseTableName: "inventory_item", constraintName: "FKFE0194169DC9C3AE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "manufacturer", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-31") {
        addForeignKeyConstraint(baseColumnNames: "department_id", baseTableName: "inventory_item_department", constraintName: "FKB7AABB1B25CADD0E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "department", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-32") {
        addForeignKeyConstraint(baseColumnNames: "inventory_item_departments_id", baseTableName: "inventory_item_department", constraintName: "FKB7AABB1B125C2B7D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "inventory_item", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-33") {
        addForeignKeyConstraint(baseColumnNames: "item_type_id", baseTableName: "size", constraintName: "FK35E00192D01595", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "item_type", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-34") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46AE1E0122C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356115251920-35") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46A61680625", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "users", referencesUniqueColumn: "false")
    }
}
