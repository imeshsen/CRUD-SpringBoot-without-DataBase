FROM maven:3.8.6-openjdk-8-slim

WORKDIR /app

COPY .  ./

COPY AppServerAgent/ /opt/appdynamics/

RUN mvn clean package

RUN rm -rf AppServerAgent/

RUN cp target/*.jar   ./

CMD java -jar *.jar

