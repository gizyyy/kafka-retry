# Kafka Retry
This is an application implemented to play with non blocking retry and dead letter topic feature of Kafka


### Installing
1. Clone this repository anywhere on your machine:
```
git clone git@github.com:gizyyy/kafka-retry.git
```

2. Run docker compose build
```
docker-compose up -d --build
```

## Installing dependencies
```bash
./gradlew build
```

## Tests and checks
To run all tests:
```bash
./gradlew test
```
## References

https://docs.spring.io/spring-kafka/docs/current/reference/html/#retry-topic
