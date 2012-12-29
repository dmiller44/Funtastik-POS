class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        "/admin/inventory"(view: '/inventory-mgmt-landing')
        "/cashregister/main"(view: "/cash-register-landing")
        "/"(view: "/landing")
        "/old"(view: "/index")
        "500"(view: '/error')
    }
}
