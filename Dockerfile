# Etapa 1: Build da aplicação nativa com GraalVM (usando uma imagem do OpenJDK)
FROM ghcr.io/graalvm/graalvm-ce:latest

# Instale dependências e ferramentas para compilar a aplicação nativa
RUN gu install native-image

# Defina o diretório de trabalho
WORKDIR /workspace

# Copie o código fonte e as dependências
COPY . /workspace/

# Compile o código para gerar o binário nativo
RUN ./mvnw clean package -Pnative

# Etapa 2: Imagem final com Distroless para rodar a aplicação nativa
FROM gcr.io/distroless/java:11

# Defina o diretório de trabalho
WORKDIR /work/

# Copie o binário nativo gerado na etapa anterior
COPY  /workspace/target/*-runner /work/app

# Exponha a porta (ajuste de acordo com sua configuração)
EXPOSE 8081

# Execute o binário nativo
CMD ["/work/app"]
