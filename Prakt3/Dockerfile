FROM openjdk:21-jdk-slim AS build

WORKDIR /app
COPY . .

RUN apt-get update && apt-get install -y wget

RUN mkdir -p src/main/resources/image
RUN wget --no-check-certificate https://www.mirea.ru/upload/medialibrary/80f/MIREA_Gerb_Colour.png -O src/main/resources/image/MIREA_Gerb_Colour.png

RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM openjdk:21-jdk-slim

WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

ENV DB_USER=postgres \
DB_PASS=postgres \
DB_URL=zverev_db:5432/postgres

EXPOSE 8080

RUN groupadd  appuser && useradd --no-log-init -g appuser appuser

VOLUME /app/userfiles
ADD https://github.com/docker/docs/blob/c5f308543d6a6334f269fcd9e82735a9ae0a80af/README.md ./userfiles/DockerDocsReadme.md
ENV USER_VOLUME=/app/userfiles

RUN chown -R appuser:appuser ./userfiles && \
   chmod 644 ./userfiles/DockerDocsReadme.md

USER appuser



ENTRYPOINT ["java", "-jar", "app.jar"]
#Args here
CMD [""] 

LABEL maintainer="Зверев Артём Александрович, ИКБО-20-21"
ONBUILD RUN echo "Сборка и запуск произведены. Автор: Зверев Артём Александрович"


