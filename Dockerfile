# Build stage
FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM amazoncorretto:17
ARG PROFILE=dev
ARG APP_VERSION=1.0.0

# define few things

WORKDIR /app
COPY --from=build /build/target/spring-springstore-*.jar /app/

ENV DB_URL=jdbc:postgresql://postgres-lab:5432/ecommerce
ENV ACTIVE_PROFILE=${PROFILE}
ENV JAR_VERSION=${APP_VERSION}

EXPOSE 8082
CMD java -jar -Dspring.profiles.active=${ACTIVE_PROFILE} -Dspring.datasource.url=${DB_URL} spring-springstore-${JAR_VERSION}.jar