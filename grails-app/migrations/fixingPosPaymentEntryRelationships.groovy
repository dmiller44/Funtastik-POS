databaseChangeLog = {

	changeSet(author: "hfdpm100 (generated)", id: "1356914124497-1") {
		addColumn(tableName: "pos_payment_entry") {
			column(name: "transaction_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "hfdpm100 (generated)", id: "1356914124497-2") {
		dropForeignKeyConstraint(baseTableName: "pos_transaction_pos_payment_entry", baseTableSchemaName: "funtastikpos", constraintName: "FK5809FA824B305F18")
	}

	changeSet(author: "hfdpm100 (generated)", id: "1356914124497-3") {
		dropForeignKeyConstraint(baseTableName: "pos_transaction_pos_payment_entry", baseTableSchemaName: "funtastikpos", constraintName: "FK5809FA82A55AAD1F")
	}

	changeSet(author: "hfdpm100 (generated)", id: "1356914124497-4") {
		createIndex(indexName: "FKB062624E3ADEB09A", tableName: "pos_payment_entry") {
			column(name: "transaction_id")
		}
	}

	changeSet(author: "hfdpm100 (generated)", id: "1356914124497-5") {
		addForeignKeyConstraint(baseColumnNames: "transaction_id", baseTableName: "pos_payment_entry", constraintName: "FKB062624E3ADEB09A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pos_transaction", referencesUniqueColumn: "false")
	}

	changeSet(author: "hfdpm100 (generated)", id: "1356914124497-6") {
		dropTable(tableName: "pos_transaction_pos_payment_entry")
	}
}
