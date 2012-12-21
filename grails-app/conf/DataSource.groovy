dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
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
            url = "jdbc:mysql://localhost/funtastikpos?useUnicode=yes&characterEncoding=UTF-8"
            username = "funtastik"
            password = "funtastik"
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
