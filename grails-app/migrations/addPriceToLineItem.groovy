databaseChangeLog = {

    changeSet(author: "hfdpm100 (generated)", id: "1361807006873-1") {
        addColumn(tableName: "pos_line_item") {
            column(name: "price", type: "double precision(19,2)") {
                constraints(nullable: "false")
            }
        }
    }
}
