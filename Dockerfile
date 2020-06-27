FROM openjdk:11
MAINTAINER Denis Khrapov
VOLUME /tmp
EXPOSE 8080
ADD battle-0.0.1-SNAPSHOT.jar battle-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/battle-0.0.1-SNAPSHOT.jar"]
