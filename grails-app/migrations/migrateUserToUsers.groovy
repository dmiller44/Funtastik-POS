databaseChangeLog = {

	changeSet(author: "dmiller (generated)", id: "1326946894551-1") {
		createTable(tableName: "users") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "usersPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false", unique: "true")
			}
		}
	}

	changeSet(author: "dmiller (generated)", id: "1326946894551-2") {
		dropForeignKeyConstraint(baseTableName: "user_role", baseTableSchemaName: "public", constraintName: "fk143bf46a870ad60c")
	}

	changeSet(author: "dmiller (generated)", id: "1326946894551-3") {
		createIndex(indexName: "username_unique_1326946894098", tableName: "users", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "dmiller (generated)", id: "1326946894551-4") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46A61680625", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "users", referencesUniqueColumn: "false")
	}

	changeSet(author: "dmiller (generated)", id: "1326946894551-5") {
		dropTable(tableName: "registration_code")
	}

	changeSet(author: "dmiller (generated)", id: "1326946894551-6") {
		dropTable(tableName: "user")
	}
}
