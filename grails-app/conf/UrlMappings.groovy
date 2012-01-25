class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        "/settings"(view: '/settings-landing')
        "/"(view: "/index")
        "500"(view: '/error')
    }
}
