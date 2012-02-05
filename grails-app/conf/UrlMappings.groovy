class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        "/settings"(view: '/landing')
        "/"(view: "/landing")
        "/old"(view: "/index")
        "500"(view: '/error')
    }
}
