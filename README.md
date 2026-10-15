# Menu Aggregate Service

A reactive RESTful microservice for aggregating restaurant menu items, reviews, and ratings from Menu Service and Review Service.

The API is available to all users. Data is retrieved from external services; the service has no database of its own.

## Tech Stack

- **Language & Framework:** Java 25, Spring Boot 4
- **Reactive Stack:** Spring WebFlux, Project Reactor, WebClient
- **Resilience:** Resilience4j (circuit breakers, retries)
- **Utilities:** Lombok
- **Documentation:** SpringDoc OpenAPI (Swagger UI)
- **Testing:** JUnit 5, WireMock, Reactor Test, AssertJ, WebTestClient
- **Containerization:** Cloud Native Buildpacks

## API Endpoints

- `GET /v1/menu-aggregate/{id}?sortBy={sortBy}&from={from}&size={size}` - Retrieve a menu item with its rating and paginated reviews sorted by creation date (`DATE_ASC`, `DATE_DESC`).
- `GET /v1/menu-aggregate?category={category}&sortBy={sortBy}` - Retrieve menu items with ratings from Review Service, filtered by category and sorted by name (`AZ`, `ZA`), price (`PRICE_ASC`, `PRICE_DESC`), creation date (`DATE_ASC`, `DATE_DESC`), or rating (`RATE_ASC`, `RATE_DESC`).

## Build and Run

Local runs require Menu Service and Review Service at the URLs configured in `src/main/resources/application.yml` (by default, `http://localhost:9091` and `http://localhost:9093`). Docker Compose also requires the `menu-service`, `review-service`, and `orders-service` images to be built beforehand.

```bash
# Run tests
./gradlew test

# Run application
./gradlew bootRun

# Build and run containerized application
./gradlew bootBuildImage
cd ./docker
docker compose up -d
```
