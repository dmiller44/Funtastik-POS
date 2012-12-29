databaseChangeLog = {

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-1") {
        createTable(tableName: "customer") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "customerPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "bonus_card_number", type: "varchar(255)")

            column(name: "first_name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "last_name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "middle_initial", type: "varchar(255)")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-2") {
        createTable(tableName: "pos_line_item") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "pos_line_itemPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "item_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "quantity", type: "integer") {
                constraints(nullable: "false")
            }

            column(name: "size_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "transaction_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-3") {
        createTable(tableName: "pos_payment_entry") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "pos_payment_ePK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "amount", type: "double precision(19,2)") {
                constraints(nullable: "false")
            }

            column(name: "cashier_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "payment_date", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "payment_method", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "reference_number", type: "varchar(255)")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-4") {
        createTable(tableName: "pos_transaction") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "pos_transactiPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "cashier_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "customer_id", type: "bigint")

            column(name: "transaction_date", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "transaction_discount", type: "double precision(19,2)") {
                constraints(nullable: "false")
            }

            column(name: "transaction_status", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-5") {
        createTable(tableName: "pos_transaction_pos_payment_entry") {
            column(name: "pos_transaction_payments_id", type: "bigint")

            column(name: "pos_payment_entry_id", type: "bigint")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-6") {
        createIndex(indexName: "FKCE4430533ADEB09A", tableName: "pos_line_item") {
            column(name: "transaction_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-7") {
        createIndex(indexName: "FKCE443053618E9AE", tableName: "pos_line_item") {
            column(name: "size_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-8") {
        createIndex(indexName: "FKCE44305370F77742", tableName: "pos_line_item") {
            column(name: "item_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-9") {
        createIndex(indexName: "FKB062624EF122842D", tableName: "pos_payment_entry") {
            column(name: "cashier_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-10") {
        createIndex(indexName: "FKBE9205738BD1168E", tableName: "pos_transaction") {
            column(name: "customer_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-11") {
        createIndex(indexName: "FKBE920573F122842D", tableName: "pos_transaction") {
            column(name: "cashier_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-12") {
        createIndex(indexName: "FK5809FA824B305F18", tableName: "pos_transaction_pos_payment_entry") {
            column(name: "pos_payment_entry_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-13") {
        createIndex(indexName: "FK5809FA82A55AAD1F", tableName: "pos_transaction_pos_payment_entry") {
            column(name: "pos_transaction_payments_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-14") {
        addForeignKeyConstraint(baseColumnNames: "item_id", baseTableName: "pos_line_item", constraintName: "FKCE44305370F77742", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "inventory_item", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-15") {
        addForeignKeyConstraint(baseColumnNames: "size_id", baseTableName: "pos_line_item", constraintName: "FKCE443053618E9AE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "size", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-16") {
        addForeignKeyConstraint(baseColumnNames: "transaction_id", baseTableName: "pos_line_item", constraintName: "FKCE4430533ADEB09A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pos_transaction", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-17") {
        addForeignKeyConstraint(baseColumnNames: "cashier_id", baseTableName: "pos_payment_entry", constraintName: "FKB062624EF122842D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "users", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-18") {
        addForeignKeyConstraint(baseColumnNames: "cashier_id", baseTableName: "pos_transaction", constraintName: "FKBE920573F122842D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "users", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-19") {
        addForeignKeyConstraint(baseColumnNames: "customer_id", baseTableName: "pos_transaction", constraintName: "FKBE9205738BD1168E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "customer", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-20") {
        addForeignKeyConstraint(baseColumnNames: "pos_payment_entry_id", baseTableName: "pos_transaction_pos_payment_entry", constraintName: "FK5809FA824B305F18", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pos_payment_entry", referencesUniqueColumn: "false")
    }

    changeSet(author: "hfdpm100 (generated)", id: "1356803478361-21") {
        addForeignKeyConstraint(baseColumnNames: "pos_transaction_payments_id", baseTableName: "pos_transaction_pos_payment_entry", constraintName: "FK5809FA82A55AAD1F", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pos_transaction", referencesUniqueColumn: "false")
    }
}
