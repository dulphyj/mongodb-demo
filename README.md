# MongoDB Spring Boot API

## Overview

This project is a **Spring Boot API** that integrates **MongoDB** as a data store. It provides a simple API to perform CRUD operations on MongoDB, demonstrating how to set up and use Spring Boot with MongoDB for data management.

## Prerequisites

- **Java 17** or later
- **Maven** (for building and running the project)
- **MongoDB** (either a local instance or a MongoDB Atlas cluster)

## Installation

### Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/dulphyj/mongodb-demo.git
cd mongodb
```

### Build and Run the Application

To build the application using Maven, run the following command:

```bash
mvn clean install
```

To run the application locally, use:

```bash
mvn spring-boot:run
```

By default, the application will start on **http://localhost:8080**.

## Configuration

### `application.properties`

Configure the MongoDB connection in the `application.properties` file:

```properties
# Application name and port
spring.application.name=mongodb-api
server.port=8080

# MongoDB configuration (replace with your own connection string)
spring.data.mongodb.uri=mongodb://localhost:27017/mongoExampleDB

# Logging level for debugging
logging.level.org.springframework=DEBUG
```

Replace the MongoDB URI with your own. For a local instance, the default URI is `mongodb://localhost:27017`.

### Example MongoDB URI for MongoDB Atlas

```properties
spring.data.mongodb.uri=mongodb://your-mongo-username:your-mongo-password@your-cluster.mongodb.net/mongoExampleDB
```

## Dependencies

The project uses the following key dependencies:

- **Spring Boot Starter Data MongoDB**: Provides the integration with MongoDB for Spring Boot.
- **Spring Boot Starter Web**: To build RESTful APIs with Spring MVC.
- **Spring Boot Starter Test**: For testing purposes, including unit and integration tests.

## Running the Application

Once the application is running, you can interact with it through the following endpoints:

- **POST /api/items**: Create a new item in MongoDB.
- **GET /api/items**: Retrieve all items from MongoDB.
- **GET /api/items/{id}**: Retrieve an item by its ID.
- **PUT /api/items/{id}**: Update an item by its ID.
- **DELETE /api/items/{id}**: Delete an item by its ID.

## Example Request and Response

### POST /api/items

Request body:

```json
{
  "name": "Item 1",
  "description": "Description of Item 1"
}
```

Response:

```json
{
  "id": "609c4f774f1b2c001f1f0b8e",
  "name": "Item 1",
  "description": "Description of Item 1"
}
```

### GET /api/items

Response:

```json
[
  {
    "id": "609c4f774f1b2c001f1f0b8e",
    "name": "Item 1",
    "description": "Description of Item 1"
  },
  {
    "id": "609c4f774f1b2c001f1f0b8f",
    "name": "Item 2",
    "description": "Description of Item 2"
  }
]
```

## Testing

The project includes unit and integration tests to ensure the API works as expected. To run the tests, use the following Maven command:

```bash
mvn test
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
