class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        "/admin/inventory"(view: '/inventory-mgmt-landing')
        "/"(view: "/landing")
        "/old"(view: "/index")
        "500"(view: '/error')
    }
}
