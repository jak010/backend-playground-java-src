# KeyWord

- NamedParameterJdbcTemplate
- RowMapper
- MapSqlParameterSource
- SpringBoot 3.x.x - SwaggerConfigure
- Java - Record
- Command Object
- Record(Data Transfer Object)
- EasyRandom (testImplementation)
- UseCase Layer
- Service Layer & Read/Write Seperate
- Bulk Insert

# Reference

- `JDBC LOGGING`
    - `build.grade`
        - implementation group: 'org.bgee.log4jdbc-log4j2', name: 'log4jdbc-log4j2-jdbc4.1', version: '1.16'
    - `application.properties`
        - spring.datasource.url=jdbc:log4jdbc:mysql://localhost:9901/sample
        - spring.datasource.driver-class-name=net.sf.log4jdbc.sql.jdbcapi.DriverSpy
- `DB::INDEX`
  - 똑같은 데이터에 똑같은 쿼리를 날려도 데이터 분포에 따라서 성능이 느릴 수 있다. 
    ```sql
    SELECT createdDate, memberId, count(id) as count FROM POST WHERE memberId=3 and createdDate BETWEEN '1900-01-01' AND '2025-01-01' GROUP BY memberId, createdDate ;
    
    SELECT createdDate, memberId, count(id) as count
    FROM POST use index(POST__index_created_date)
    WHERE memberId=3 and createdDate BETWEEN '1900-01-01' AND '2025-01-01' GROUP BY memberId, createdDate ;
    ```