# Etapa 1: Construção da aplicação
FROM maven:3.8.4-openjdk-17-slim AS build

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando os arquivos de código fonte para o contêiner
COPY pom.xml ./
COPY src ./src

# Instalando as dependências do Maven
RUN mvn clean install -DskipTests

# Etapa 2: Imagem para execução da aplicação em modo dev
FROM openjdk:17-jdk-slim

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando as dependências e o código da etapa de build
COPY --from=build /app/target /app/target
COPY --from=build /app/pom.xml /app/pom.xml
COPY --from=build /app/src /app/src

# Variáveis de ambiente para o modo dev
ENV QUARKUS_PROFILE=dev
ENV MAVEN_OPTS="-Dmaven.repo.local=/app/.m2/repository"

# Expondo a porta padrão do Quarkus para dev
EXPOSE 8080

# Rodando o Quarkus no modo dev
CMD ["mvn", "quarkus:dev", "-Dquarkus.http.host=0.0.0.0", "-Dquarkus.http.port=8080"]
