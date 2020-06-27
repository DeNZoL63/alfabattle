FROM openjdk:11
EXPOSE 8082
ADD battle-0.0.1-task3.jar /opt/
ENTRYPOINT ["/usr/local/openjdk-11/bin/java"]
CMD ["-jar", "/opt/battle-0.0.1-task3.jar"]