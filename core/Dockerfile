FROM igeting/openjdk:1.8-alpine
ENV LANG=en_US.UTF-8
ADD target/core.jar /code/core.jar
ADD config/${RUN_ENV} /code/config
#ENTRYPOINT ["java", "-Xbootclasspath/a:/code/config", "-jar", "/code/core.jar"]
ENTRYPOINT ["java", "-cp", "/code/core.jar:/code/config", "org.springframework.boot.loader.JarLauncher"]
