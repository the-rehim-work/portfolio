# Welcome to My Spring Portfolio

## Task
Build a web application to track an investor's active investments with a starting fund of $10 million USD, supporting CRUD operations, sorting, and fund management.

## Description
Spring Boot MVC application using Thymeleaf for server-side rendering and H2 in-memory database. Users can create investments, update investment names, add funds to the pool, view individual investment details, and sort investments by amount or name. A notification toast appears 2 minutes after creating a new investment.

## Installation

Ensure you have Java 21 installed on your machine. Clone the repository and navigate to the project directory.
```
git clone <repository-url>
cd portfolio
```

Install dependencies and build the project using the Maven wrapper included in the repository:
```
./mvnw clean install
```

This will download all required dependencies, compile the source code, and package the application into a runnable JAR file located in the `target/` directory.

## Usage
```
java -jar target/portfolio-0.0.1-SNAPSHOT.jar
```
Then open http://localhost:8080

### The Core Team


<span><i>Made at <a href='https://qwasar.io'>Qwasar SV -- Software Engineering School</a></i></span>
<span><img alt='Qwasar SV -- Software Engineering School's Logo' src='https://storage.googleapis.com/qwasar-public/qwasar-logo_50x50.png' width='20px' /></span>