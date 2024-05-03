Notes API - Crud API for Notes

Spring Boot Starter Project Reference Link -
https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.5&packaging=jar&jvmVersion=17&groupId=com.pradipta&artifactId=notes-api&name=notes-api&description=Demo project for Spring Boot&packageName=com.pradipta.notes.api&dependencies=devtools,lombok,configuration-processor,web,actuator,testcontainers,data-jpa,flyway,h2,postgresql,validation

Flyway migration
----------------
Dependency added -
<dependency>
<groupId>org.flywaydb</groupId>
<artifactId>flyway-core</artifactId>
</dependency>

Scripts need to be kept in db.migration folder.

The name of the files should be - V<version>__<name of file>.sql

Flyway keeps the history of script executions in the flyway_schema_history table.

Database vendor specific scripts can be kept like this -
spring.flyway.locations=classpath:/db/migration/{vendor}