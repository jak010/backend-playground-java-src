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
- Paginateion - Offset Based
- PageAble
- PageRequest
- FanOut Model - Push&Pull

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
- `Parameter로 Sort를 받지 않음`
    - Sort 같은 경우 INDEX와 관련이 있기 때문에 보통 Sort를 Parameter로 받지 않는다.
    - Sort 를 Parameter로 받아서 처리할 경우 다른 DB와 함께 사용함
- `OffSet 기반의 페이지네이션 문제점`
    - 마지막 페이지를 구하기 위해 전체 갯수를 알아야함
- `Cursor Based Paginate`Example
    ```sql
    SELECT * FROM POST WHERE memberId = 4 and id > 10000;
    ```