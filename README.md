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

DTO projection
--------------
JPA entities can be mapped to DTOs in the following manner -
@Query("select new com.pradipta.notes.api.domain.NoteDTO(n.id, n.title, n.content, n.createdAt) from Note n")
Page<NoteDTO> findBookmarks(Pageable pageable);

Integration test with TestContainers
------------------------------------
Adding the following in the Junit test case enables the TestContainers.
@TestPropertySource(properties = {
"spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
})
Docker should already be running to make the test run.

Build the Docker Image
----------------------
Add the following Maven plugin -
<build>
<plugins>
<plugin>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-maven-plugin</artifactId>
<configuration>
<image>
<name>nagpradipta1985/notes-api</name>
</image>
<excludes>
<exclude>
<groupId>org.projectlombok</groupId>
<artifactId>lombok</artifactId>
</exclude>
</excludes>
</configuration>
</plugin>
</plugins>
</build>

Run the following Maven command to build the image -
./mvnw spring-boot:build-image

Built image can be run with the command -
docker run -p 8080:8080 nagpradipta1985/notes-api