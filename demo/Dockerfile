FROM openjdk:8-jdk-alpine
ENV HW_HOME=/opt/hello-world
ADD /target/*.jar $HW_HOME/
WORKDIR $HW_HOME
ENTRYPOINT ["java","-jar","TestApp.jar"]
