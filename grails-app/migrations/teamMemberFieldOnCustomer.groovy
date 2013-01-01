databaseChangeLog = {

    changeSet(author: "hfdpm100 (generated)", id: "1357084689902-1") {
        addColumn(tableName: "customer") {
            column(name: "team_member", type: "bit") {
                constraints(nullable: "false")
            }
        }
    }
}
