#
# Build stage
#

FROM maven:3.6.3-jdk-11 AS build

WORKDIR /

COPY . ./

RUN mvn clean package

#
# Package stage
#

FROM openjdk:11-jre-slim

ARG JAR_NAME="livenessProbe"

WORKDIR /

COPY --from=build /target/${JAR_NAME}.jar ./app.jar

EXPOSE 50001

CMD ["java","-jar", "./app.jar"]