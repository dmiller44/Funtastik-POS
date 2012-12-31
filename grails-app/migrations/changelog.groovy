databaseChangeLog = {

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-1") {
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

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-2") {
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

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-3") {
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

            column(name: "retail_price", type: "double precision(19,2)") {
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

            column(name: "wholesale_price", type: "double precision(19,2)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-4") {
        createTable(tableName: "inventory_item_department") {
            column(name: "inventory_item_departments_id", type: "bigint")

            column(name: "department_id", type: "bigint")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-5") {
        createTable(tableName: "inventory_item_record") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "inventory_itePK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "inventory_item_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "price_quantifier", type: "double precision(19,2)") {
                constraints(nullable: "false")
            }

            column(name: "qoh", type: "integer") {
                constraints(nullable: "false")
            }

            column(name: "size_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-6") {
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

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-7") {
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

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-8") {
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

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-9") {
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

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-10") {
        createTable(tableName: "user_role") {
            column(name: "role_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-11") {
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

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-12") {
        addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-13") {
        createIndex(indexName: "name_unique_1356724603629", tableName: "color", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-14") {
        createIndex(indexName: "name_unique_1356724603633", tableName: "department", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-15") {
        createIndex(indexName: "FKFE019416642981C6", tableName: "inventory_item") {
            column(name: "color_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-16") {
        createIndex(indexName: "FKFE01941692D01595", tableName: "inventory_item") {
            column(name: "item_type_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-17") {
        createIndex(indexName: "FKFE0194169DC9C3AE", tableName: "inventory_item") {
            column(name: "manufacturer_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-18") {
        createIndex(indexName: "name_unique_1356724603643", tableName: "inventory_item", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-19") {
        createIndex(indexName: "sku_code_unique_1356724603644", tableName: "inventory_item", unique: "true") {
            column(name: "sku_code")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-20") {
        createIndex(indexName: "FKB7AABB1B125C2B7D", tableName: "inventory_item_department") {
            column(name: "inventory_item_departments_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-21") {
        createIndex(indexName: "FKB7AABB1B25CADD0E", tableName: "inventory_item_department") {
            column(name: "department_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-22") {
        createIndex(indexName: "FKF3E0309A618E9AE", tableName: "inventory_item_record") {
            column(name: "size_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-23") {
        createIndex(indexName: "FKF3E0309AEC861B5F", tableName: "inventory_item_record") {
            column(name: "inventory_item_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-24") {
        createIndex(indexName: "name_unique_1356724603650", tableName: "item_type", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-25") {
        createIndex(indexName: "name_unique_1356724603652", tableName: "manufacturer", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-26") {
        createIndex(indexName: "authority_unique_1356724603654", tableName: "role", unique: "true") {
            column(name: "authority")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-27") {
        createIndex(indexName: "FK35E00192D01595", tableName: "size") {
            column(name: "item_type_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-28") {
        createIndex(indexName: "FK143BF46A61680625", tableName: "user_role") {
            column(name: "user_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-29") {
        createIndex(indexName: "FK143BF46AE1E0122C", tableName: "user_role") {
            column(name: "role_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-30") {
        createIndex(indexName: "username_unique_1356724603659", tableName: "users", unique: "true") {
            column(name: "username")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-31") {
        addForeignKeyConstraint(baseColumnNames: "color_id", baseTableName: "inventory_item", constraintName: "FKFE019416642981C6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "color", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-32") {
        addForeignKeyConstraint(baseColumnNames: "item_type_id", baseTableName: "inventory_item", constraintName: "FKFE01941692D01595", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "item_type", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-33") {
        addForeignKeyConstraint(baseColumnNames: "manufacturer_id", baseTableName: "inventory_item", constraintName: "FKFE0194169DC9C3AE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "manufacturer", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-34") {
        addForeignKeyConstraint(baseColumnNames: "department_id", baseTableName: "inventory_item_department", constraintName: "FKB7AABB1B25CADD0E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "department", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-35") {
        addForeignKeyConstraint(baseColumnNames: "inventory_item_departments_id", baseTableName: "inventory_item_department", constraintName: "FKB7AABB1B125C2B7D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "inventory_item", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-36") {
        addForeignKeyConstraint(baseColumnNames: "inventory_item_id", baseTableName: "inventory_item_record", constraintName: "FKF3E0309AEC861B5F", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "inventory_item", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-37") {
        addForeignKeyConstraint(baseColumnNames: "size_id", baseTableName: "inventory_item_record", constraintName: "FKF3E0309A618E9AE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "size", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-38") {
        addForeignKeyConstraint(baseColumnNames: "item_type_id", baseTableName: "size", constraintName: "FK35E00192D01595", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "item_type", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-39") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46AE1E0122C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356724603703-40") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46A61680625", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "users", referencesUniqueColumn: "false")
    }

    include file: 'addingPosSystemObjects.groovy'

	include file: 'fixingPosPaymentEntryRelationships.groovy'
}
