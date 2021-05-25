# Movie Catalog Web App

**Spring Boot, Spring MVC, Thymeleaf, Spring Security, Spring AOP, Spring Data JPA**

A web application where movies can be recorded and can be add actors to movies. Filtering and sorting can be done according to the genre, language, etc. of the movie.

## Requirements

* [JDK 11+](https://www.oracle.com/java/technologies/javase-downloads.html)
* [Maven 3.2+](https://maven.apache.org/download.cgi)
* [MySQL 5 or 8](https://dev.mysql.com/downloads/mysql/)


## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/furkanisitan/movie-catalog.git
```

**2. Create a database on the MySql server.**

**3. Set the `spring.datasource.username`, `spring.datasource.password`, and `spring.datasource.url` properties in the `src/main/resources/application.properties` file.**

**4. Run the application using maven in the root directory of the application.**

```bash
mvnw spring-boot:run
```
The app will start running at <http://localhost:8080>

Note: For running tests, create a separate database and set up the `src/main/resources/application-test.properties` file.

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#using-boot-devtools)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-security)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

## Author

**Furkan Işıtan**

* [github/furkanisitan](https://github.com/furkanisitan)
