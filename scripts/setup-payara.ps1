asadmin create-jdbc-connection-pool `
    --datasourceclassname org.h2.jdbcx.JdbcDataSource `
    --restype javax.sql.DataSource `
    --property "URL=jdbc:h2:mem:catalog;DB_CLOSE_DELAY=-1;MODE=LEGACY" `
    catalogPool

asadmin create-jdbc-resource `
    --connectionpoolid catalogPool `
    jdbc/catalog