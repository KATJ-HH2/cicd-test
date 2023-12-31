# 개발 환경용 Dockerfile

# 베이스 이미지 설정 (Java 17을 사용) oracle
FROM amazoncorretto:17

# 애플리케이션 JAR 파일 복사
COPY build/libs/*.jar ./app.jar

## 개발 환경 프로파일 설정
ENV SPRING_PROFILES_ACTIVE=dev

# 포트 설정
EXPOSE 8080

# 애플리케이션 실행
CMD ["java", "-jar", "./app.jar"]