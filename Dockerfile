FROM openjdk:11
EXPOSE 8080
WORKDIR /usr/app
COPY ./target/CPUTest-1.0-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
#CMD ls
#CMD dir
#RUN java -version
#RUN java -jar StatefullTest-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","CPUTest-1.0-SNAPSHOT.jar"]
