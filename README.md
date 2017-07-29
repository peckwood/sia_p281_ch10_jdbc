#### data source

Shows How Spring can integrate different kinds of imbedded, external databases, though JDBC or connection pools.

methods:

| class                      | jdbc/pool   | database | Spring built in?  |      |
| -------------------------- | ----------- | -------- | ----------------- | ---- |
|                            | embeded(h2) | h2       | supports embedded |      |
| DriverManagerDataSource    | jdbc        | MySQL    | Yes               |      |
| SimpleDriverDataSource     | jdbc        | MySQL    | Yes               |      |
| SingleConnectionDataSource | jdbc        | MySQL    | Yes               |      |
| BasicDataSource            | pool        | dbcp2    | no                |      |
| ComboPooledDataSource      | pool        | c3p0     | no                |      |
| DruidDataSource            | pool        | druid    | no                |      |

Has both xml(data.xml) and Java(`jdbc.config.DataConfig`) configurations

#### jdbcTemplate

By integrating JDBC, jdbcTemplate elimates boilerplates code.

See `jdbc.data.JdbcUserRepository` for how.

`mapRow()` maps result sets to Java objects.