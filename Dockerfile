FROM igeting/openjdk:1.8-alpine
ENV LANG=en_US.UTF-8
ADD target/demo.jar /code/demo.jar
ADD config /code/config
ENTRYPOINT ["java", "-cp", "/code/demo.jar:/code/config", "org.springframework.boot.loader.JarLauncher"]