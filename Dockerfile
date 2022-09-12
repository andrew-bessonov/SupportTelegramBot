FROM maven:openjdk as build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN mvn package

FROM openjdk:17
COPY --from=build /usr/app/target/*.jar /app/telegram-bot-service.jar
ENTRYPOINT java -jar /app/telegram-bot-service.jar