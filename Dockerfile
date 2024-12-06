FROM openjdk:17

VOLUME /tmp

WORKDIR /app

LABEL authors="Emerson H.V."

COPY ./target/APIFranquicias-0.0.1-SNAPSHOT.jar api.jar

ENTRYPOINT ["java", "-jar", "api.jar"]