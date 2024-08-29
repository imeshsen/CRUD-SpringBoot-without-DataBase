FROM maven:3.8.6-openjdk-8-slim

WORKDIR /app

COPY .  ./

COPY AppServerAgent/ /opt/appdynamics/

ENV JAVA_OPTS -javaagent:/opt/appdynamics/javaagent.jar

RUN mvn clean package

RUN rm -rf AppServerAgent/

RUN cp target/*.jar   ./

CMD java $JAVA_OPTS  -jar *.jar

