# Spring Boot RestClient Demo

This project is a small Java Spring Boot application that demonstrates how to use Spring's `RestClient` to call an external REST API from a server-side application.

The demo exposes local endpoints under `/api/posts` and internally calls [JSONPlaceholder](https://jsonplaceholder.typicode.com), a free fake REST API for testing.

## Why RestClient was introduced

Spring introduced `RestClient` in Spring Framework 6.1 to provide a modern synchronous HTTP client with a cleaner and more fluent API than `RestTemplate`.

It was introduced mainly because:

- `RestTemplate` is widely used, but its API feels older and less fluent for modern Spring applications.
- Many teams still want a blocking and simple HTTP client instead of the reactive `WebClient`.
- Spring wanted a client that reuses modern infrastructure such as message converters, interceptors, and request factories, while keeping the coding style more expressive.

In short:

- Use `RestClient` when you want synchronous HTTP calls with modern syntax.
- Use `WebClient` when you need reactive or non-blocking communication.

## Advantages of RestClient

- Fluent and readable API for GET, POST, PUT, DELETE, and custom request handling.
- Simpler migration path for teams already familiar with `RestTemplate`.
- Good fit for standard Spring Boot MVC applications.
- Supports Spring's existing HTTP infrastructure.
- Less boilerplate for common API integrations.

## Limitations of RestClient

- It is still a blocking client, so it is not ideal for highly concurrent reactive workloads.
- For streaming or advanced reactive flows, `WebClient` is usually a better choice.
- If your application architecture is fully non-blocking, `RestClient` does not align as well as reactive clients.
- Error handling and retries still need to be designed explicitly for production use.

## Tech Stack

- Java 17+
- Spring Boot
- Gradle
- Spring Web
- JUnit 5 / Spring Boot Test

## Gradle dependencies

The main Gradle dependencies used in this project are:

```gradle
implementation 'org.springframework.boot:spring-boot-starter-web'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
```

`spring-boot-starter-web` gives us:

- Spring MVC
- Embedded server support
- JSON serialization with Jackson
- Spring `RestClient` support through Spring Web

## Project structure

```text
src/main/java/com/example/restclientdemo
|-- RestClientDemoApplication.java
|-- config/RestClientConfig.java
|-- controller/PostController.java
|-- dto/PostDto.java
`-- service/JsonPlaceholderService.java
```

## API flow

1. Client calls this app on `http://localhost:8080/api/posts`.
2. `PostController` receives the request.
3. `JsonPlaceholderService` uses Spring `RestClient`.
4. The service calls `https://jsonplaceholder.typicode.com/posts`.
5. The response is returned back from this app to the caller.

## Endpoints

### 1. Get all posts

```http
GET /api/posts
```

### 2. Get a single post by id

```http
GET /api/posts/{id}
```

Example:

```http
GET /api/posts/1
```

### 3. Create a post

```http
POST /api/posts
Content-Type: application/json
```

Sample request body:

```json
{
  "userId": 1,
  "title": "RestClient demo",
  "body": "Created through the Spring Boot sample app"
}
```

## How to run

### Prerequisites

- Java 17 or newer
- A working Gradle installation

### Start the application

```bash
gradle bootRun
```

The app starts on:

```text
http://localhost:8080
```

## Postman collection

Import this file into Postman:

[`postman/RestClient Demo.postman_collection.json`](/Users/krishnajanaswamy/Documents/BackendProjects/RestClient/postman/RestClient%20Demo.postman_collection.json)

Included requests:

- Get all posts
- Get post by id
- Create post

## Example curl commands

```bash
curl http://localhost:8080/api/posts
```

```bash
curl http://localhost:8080/api/posts/1
```

```bash
curl -X POST http://localhost:8080/api/posts \
  -H "Content-Type: application/json" \
  -d '{
    "userId": 1,
    "title": "RestClient demo",
    "body": "Created through the Spring Boot sample app"
  }'
```

## Notes

- This is a learning/demo project, not a production-ready API client.
- The external service used here is JSONPlaceholder, so created records are mock responses.
- For production systems, consider adding timeout configuration, exception mapping, logging, retries, and tests around external API behavior.
# ReactClient
