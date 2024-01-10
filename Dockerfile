FROM maven:3.8.6-openjdk-8

RUN useradd -m myuser

USER myuser

WORKDIR /app

COPY .  ./

CMD ["mvn" , "spring-boot:run"]
