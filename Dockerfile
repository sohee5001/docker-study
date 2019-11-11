#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
##ENTRYPOINT ["java","-jar","/app.jar"]

  # ARG 변수 설정.
  # COPY 새파일과 디렉토리를 고정이미지 app.jar에 복사한다.
  # ENTRYPOINT 해당 응용프로그램이 컨테이너 내부에서 실행되는 방법을 구성.

FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=./target/kafka-test-0.1.5.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]