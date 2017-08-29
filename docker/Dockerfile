FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JHIPSTER_SLEEP=0 \
    JAVA_OPTS=""

# add directly the war
ADD  build/libs/*.war /app.war

EXPOSE 8080
CMD echo "The application will start in 5s..." && \
    sleep 5 && \
    java ${JAVA_OPTS} -jar /app.war
