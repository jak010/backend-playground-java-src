# Index

- NamedParameterJdbcTemplate
- RowMapper
- MapSqlParameterSource
- SpringBoot 3.x.x - SwaggerConfigure
- Java - Record
- Command Object
- Dto
- EasyRandom (testImplementation)

# Reference

- `JDBC LOGGING`
    - `build.grade`
        - implementation group: 'org.bgee.log4jdbc-log4j2', name: 'log4jdbc-log4j2-jdbc4.1', version: '1.16'
    - `application.properties`
        - spring.datasource.url=jdbc:log4jdbc:mysql://localhost:9901/sample
        - spring.datasource.driver-class-name=net.sf.log4jdbc.sql.jdbcapi.DriverSpy
