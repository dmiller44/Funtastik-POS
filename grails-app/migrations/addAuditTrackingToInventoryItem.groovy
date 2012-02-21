databaseChangeLog = {

	changeSet(author: "dmiller (generated)", id: "1329790734754-1") {
		addColumn(tableName: "inventory_item") {
			column(name: "create_date", type: "timestamp") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "dmiller (generated)", id: "1329790734754-2") {
		addColumn(tableName: "inventory_item") {
			column(name: "created_by", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "dmiller (generated)", id: "1329790734754-3") {
		addColumn(tableName: "inventory_item") {
			column(name: "updated_by", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "dmiller (generated)", id: "1329790734754-4") {
		addColumn(tableName: "inventory_item") {
			column(name: "updated_date", type: "timestamp") {
				constraints(nullable: "false")
			}
		}
	}
}
