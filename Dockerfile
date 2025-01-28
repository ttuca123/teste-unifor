# Etapa 1: Construção da aplicação
FROM maven:3.8.4-openjdk-17-slim AS build

# Definindo o diretório de trabalho
WORKDIR /work/

# Copiando o POM para o contêiner para garantir que o Maven tenha acesso a ele
COPY ./pom.xml /work/

# Baixando as dependências do Maven (isso ajuda a evitar rebaixamento desnecessário de dependências)
RUN mvn dependency:go-offline

# Copiando o código fonte para o contêiner
COPY src /work/src/

# Instalando as dependências do Maven e construindo o projeto
RUN mvn clean package -DskipTests

# Copiando os artefatos gerados para o contêiner
COPY --chown=1001:root target/*-runner /work/

EXPOSE 8080
USER 1001

CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]

# Etapa 2: Imagem para execução da aplicação
FROM registry.access.redhat.com/ubi8/openjdk-17:1.15

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando o JAR gerado para a imagem final
COPY --from=build /work/target/quarkus-app/quarkus-run.jar /app/quarkus-run.jar

# Variáveis de ambiente necessárias para o Quarkus
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Dquarkus.http.port=8080"

# Comando para executar a aplicação
CMD ["java", "-jar", "/app/quarkus-run.jar"]
