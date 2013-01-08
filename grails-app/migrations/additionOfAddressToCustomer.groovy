databaseChangeLog = {

    changeSet(author: "hfdpm100 (generated)", id: "1357606301455-1") {
        createTable(tableName: "address") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "addressPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "city", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "extended_street_address", type: "varchar(255)")

            column(name: "state_abbr", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "street_address", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "zip_code", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1357606301455-2") {
        addColumn(tableName: "customer") {
            column(name: "address_id", type: "bigint")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1357606301455-3") {
        addColumn(tableName: "customer") {
            column(name: "home_phone", type: "varchar(255)")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1357606301455-4") {
        addColumn(tableName: "customer") {
            column(name: "mobile_phone", type: "varchar(255)")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1357606301455-5") {
        createIndex(indexName: "FK24217FDE85E3E126", tableName: "customer") {
            column(name: "address_id")
        }
    }

    changeSet(author: "hfdpm100 (generated)", id: "1357606301455-6") {
        addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "customer", constraintName: "FK24217FDE85E3E126", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "address", referencesUniqueColumn: "false")
    }
}
