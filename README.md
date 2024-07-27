# Learning Management Platform

This is the backend service of learning management system

## How to setup and run the project

### Prerequisites

You would need the following tools installed before running the project locally:

- Java 17
- Gradle
- IntelliJ IDEA (or any preferred IDE)
- Docker

### Configure environment variables

1. Create .env file in the root folder with database credentials:

```
MYSQL_HOST=Localhost
MYSQL_PORT=3306
MYSQL_DB=ms_production_db
MYSQL_ALLOW_EMPTY_PASSWORD=false
DATABASE_URL=jdbc:mysql://${MYSQL_HOST}:$[MYSQL_PORT}/${MYSQL_DB}?createDatabaseIfNotExist=true
DATABASE_USERNAME=root
DATABASE_PASSWORD=supersecretpassword
```

### Start the project

  - run `gradle clean build` in a terminal or in InteliJ Gradle menu to get all the needed dependencies and to build the project
  - run `docker-compose up -d --build` in a terminal in the root folder
     - This command will start a MySQL DB and the App in a docker containers with the properties we've entered in the .env file
  - when you Run -> Run in InteliJ, the application will run locally with H2 database
  - The app should be running on localhost:8080

