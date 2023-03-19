## Sub-Projects and their Goals

This repository is composed of several sub-projects, each utilizing Spring Boot 3 with distinct goals and objectives. Here is a brief overview of the high-level objectives of each sub-project:

### spring-boot-webapplication
- Develop a Spring Boot web application that can serve dynamic content and interact with third-party apps through a JSON-based API by:
  - Injecting demo data using a service to populate the dynamic content on the web pages.
  - Creating a web controller that uses Mustache, a templating engine, to render dynamic content based on the demo data. The controller will retrieve the data from the service and pass it to the Mustache templates to render the web pages.
  - Creating a JSON-based API that allows third-party apps to interact with the web application.
  - Leveraging Node.js to introduce some JavaScript to our web application allowing for additional functionality to be added to the application, such as client-side scripting or server-side logic.

### spring-data-jpa-queries
- Query for data using Spring Data JPA:
  - Writing custom finders.
  - Using Query By Example.
  - Directly accessing the data store using custom JPQL and SQL.
- Hook variations of queries into search boxes.
- Use Java 17 records to quickly assemble DTOs that can be used to ferry form requests into web methods and onto VideoService to simplify development.
- Assess when it makes sense to use different querying tactics by understanding the trade-offs and benefits of each approach.

### spring-method-level-security's primary purpose is to provide more granular security to Spring Data methods by implementing method-level security using Spring Security.
#### Functional Goals:
- Implement security for individual methods in a Spring Boot application using Spring Security's @Secured annotation.
- Verify that only users with appropriate roles can access secured methods.
- Test that users without appropriate roles are denied access to secured methods.

#### Behavioral Goals:
- Ensure that the application behaves correctly when securing methods with Spring Security.
- Verify that appropriate error messages are displayed to users who are denied access to secured methods.
- Verify that secured methods can still be accessed by users with appropriate roles.

### spring-security-oauth2
- Outsource user management to Google using Spring Security’s OAuth2 integration.
- Take advantage of this by grabbing hold of some YouTube data and serve up video links.

### spring-boot-testing

#### Primary Purpose:
- Demonstrate how to use Mockito to create and manage mock objects for testing Spring Boot data repositories through test cases that validate the behavior of service layer methods that depend on them, as exemplified by the provided code snippet testing the VideoService class methods interacting with a VideoRepository.

#### Functional Goals:
- Ensure that
  - Data repositories are functioning correctly by testing them with mocks, embedded databases, and containerized databases.
  - Web controllers are correctly handling HTTP requests and responses by testing them using MockMVC.
  - Security policies are properly implemented and enforced by testing them in a controlled environment.

#### Behavioral Goals:
- Understand how to
  - Effectively test data repositories using various techniques such as mocks, embedded databases, and containerized databases.
  - Use MockMVC to test web controllers and endpoints for Spring Boot applications.
  - Test security policies in Spring Boot applications and ensure the application is secure against unauthorized access.

### spring-boot-configuration-management
- Externalize parts of our system from content that appears in the web layer to the list of users allowed to authenticate with the system.
- Create type-safe configuration classes, bootstrap them from property files, and then inject them into parts of our application.
- Use profile-based properties and choose between using traditional Java property files or using YAML
- Override property settings from the command line

### spring-boot-release-management
- Turn our application from a collection of code into an executable, ready for any production environment, including the cloud:
  - Creating an uber JAR that is runnable anywhere.
  - Baking a Docker container image that can be run locally with no need for Java.
  - Pushing our Docker container to Docker Hub where it can be consumed by our clients.
- Manage/tune/tweak applications once deployed so that we could scale it up as needed:
  - Running multiple instances of our uber JAR pointed at a persistent database, different than the one it came bundled with.

### spring-native-image-build
- Build native images using GraalVM. This is a faster, more efficient version of our application than we could ever build using the standard JVM.
  - Retrofit our application for GraalVM
  - Run our native Spring Boot application inside GraalVM
- Bake native images into a Docker container using Paketo Buildpacks.
  - Bake a Docker container with GraalVM

### web-api-spring-webflux
- Create a reactive application using Project Reactor.
- Roll out reactive web methods to both serve and consume JSON.
- Leverage Thymeleaf to reactively generate HTML and consume an HTML form.
- Reactively generate a hypermedia-aware API using Spring HATEOAS.

### spring-boot-r2dbc-integration
- Explain what it means to fetch data reactively.
- Build an introductory reactive Spring Boot application.
  - Leverage Spring Data to help manage our content.
  - Create a reactive data repository, Spring Data Commons’ base interface for any reactive repository, ReactiveCrudRepository.
  - Load test data by injecting a copy of our Spring Data R2DBC bean(R2dbcEntityTemplate) to the application's context.
  - Return data reactively to our API controller that will be used to generate our web template served up at the root of our domain.

### spring-data-jpa-integration-testing
- Create a database schema that describes how to construct our database, then:
  - Validate Entity Mappings.
  - Verify Constraints.
- Reset the database to a known state after each test.
- Insert sufficient and appropriate data.
- Test against a real database:
  - Test Custom Queries: Inferred, JPQL, and Native SQL Queries.
  - Test db migrations.

### spring-rabbitmq-listener-test
- Ensure seamless integration between components by performing integration tests between:
  - A component responsible for publishing messages to a RabbitMQ exchange.
  - An AMQP listener that consumes messages from a RabbitMQ queue. The queue will be bound to the exchange to facilitate communication between the two components.

### spring-data-cassandra-observability's core purpose is to demonstrate observability in a Spring Data Cassandra application.
The project aims to:
- Demonstrate the usage of Micrometer for measuring various aspects of a Spring Data Cassandra application.
- Demonstrate the creation of observability points in a Spring Data Cassandra application using Micrometer.
- Provide functional examples of all essential components of our Spring Data Cassandra application:
  - An application that utilizes observability points to measure different performance aspects.
  - A configuration class that establishes a connection to Cassandra for the Spring Data Cassandra application.
  - A controller class that manages HTTP requests in the Spring Data Cassandra application.
  - A repository class that handles interactions with the Cassandra database in the Spring Data Cassandra application.
  - An entity class that represents data in the Cassandra database for the Spring Data Cassandra application.