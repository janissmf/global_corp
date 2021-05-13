# Global Corp

## Running app

- In order to run the application locally the Redis app must be installed
- IntelliJ IDEA creates a Spring Boot run configuration that you can use to run your new Spring
  application. It should be selected by default, so you can press Shift+10
- You can run application locally used maven command. Run this inside your {project} run {mvn
  spring-boot:run}

### Redis:

- [Redis install guide](https://kasunprageethdissanayake.medium.com/installing-redis-x64-3-2-100-on-windows-and-running-redis-server-94db3a98ae3d)

## Endpoints

- [localhost:8080/actuator](localhost:8080/actuator)

- [localhost:8080/api/migration/ocr](localhost:8080/api/migration/ocr)
- [localhost:8080/api/all](localhost:8080/api/all)
- [localhost:8080/api/cached/details/{id}](localhost:8080/api/cached/details/129)
- [localhost:8080/api/cached/all](localhost:8080/api/cached/all)
- [localhost:8080/api/cached/flush](localhost:8080/api/cached/flush)
- [localhost:8080/api/cached/possibly-some?word=testWord](localhost:8080/api/cached/possibly-some?word=testWord)