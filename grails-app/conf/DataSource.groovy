dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            url = "jdbc:postgresql://localhost:5432/funtastik-dev"
            driverClassName = "org.postgresql.Driver"
            username = "funtastik"
        }
    }
    test {
        dataSource {
            url = "jdbc:postgresql://localhost:5432/funtastik-test"
            driverClassName = "org.postgresql.Driver"
            username = "funtastik"
        }
    }
    production {
        dataSource {
            url = "jdbc:postgresql://localhost:5432/funtastik-prod"
            driverClassName = "org.postgresql.Driver"
            username = "funtastik"
        }
    }
}
