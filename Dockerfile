FROM maven:3.8.6-openjdk-8

WORKDIR /app

COPY .  ./

CMD ["mvn" , "spring-boot:run"]
