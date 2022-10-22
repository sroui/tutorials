FROM openjdk:11-jre-slim-buster

WORKDIR /opt/

RUN ln -s /usr/local/openjdk-11/bin/java /usr/bin/java

ENTRYPOINT ["/opt/docker-entrypoint.sh"]

ENV USER_NAME spring
ENV APP_HOME /opt/$USER_NAME/app
ENV SPRING_PROFILES_ACTIVE=default

ENV JVM_HEAP_MIN="256m" \
    JVM_HEAP_MAX="500m"

# Add a volume pointing to /tmp, used by Tomcat
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Create the user that will run the application
RUN adduser --shell /bin/bash --home /opt/$USER_NAME $USER_NAME
RUN mkdir -p $APP_HOME

# Add the application's jar to the container
ADD target/*.jar $APP_HOME/application.jar
RUN chown -R $USER_NAME: $APP_HOME

USER $USER_NAME
WORKDIR $APP_HOME

# Run the jar file
#
# See https://spring.io/guides/gs/spring-boot-docker/
#
ENTRYPOINT ["/usr/bin/java", "-XX:+UseG1GC -Dfile.encoding=UTF-8 -Djava.net.preferIPv4Stack=true",
            "-Djava.security.egd=file:/dev/./urandom", "-jar", "application.jar"]
