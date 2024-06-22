FROM eclipse-temurin:21-jdk as builder

WORKDIR /app

COPY . /app

RUN ./gradlew clean build -x test

FROM eclipse-temurin:21-jre

VOLUME /tmp

COPY --from=builder /app/build/libs/my-menu-app-spring-0.0.1-SNAPSHOT.jar my-menu-app.jar

ENTRYPOINT ["java","-jar","/my-menu-app.jar"]