
# SisAcad Unifor 🐳

Este é um projeto simples utilizando **Quarkus** para desenvolvimento de microserviços, com integração ao **Docker** para facilitar o deployment em containers.
O projeto foi desenvolvido com o framework Quarkus que é uma stack Java leve e otimizada para aplicações em nuvem. Também utiliza o Docker para criar, distribuir e rodar aplicativos em containers de maneira eficiente.

## 🚀 Funcionalidades da Aplicação
- Manter Alunos
- Manter Professor
- Manter Usuário
- Manter Disciplina
- Manter Curso
- Matricular Aluno
- Manter Matriz Curricular
## 🚀 Caracteristicas da Aplicação
- Utilização de microserviços de forma rápida e eficiente com Quarkus.
- Dockerização do serviço para facilitar o deploy em qualquer ambiente.
- Integração entre **Quarkus e Docker**.
- Integração com **KeyCloack** para autenticação e permissão.

## 🔧 Requisitos

Antes de começar, você precisa ter os seguintes softwares instalados na sua máquina:

- **Java 17** ou superior.
- **Docker**.
- **Maven** (para build do projeto Quarkus).

## 💻 Como rodar localmente

### 1 Clonando o repositório

Clone este repositório em sua máquina local:

``` git clone https://github.com/ttuca123/teste-unifor.git ```

```cd teste-unifor ```

1.2 Rodando o projeto com Maven
Se você quiser rodar o projeto diretamente com Maven (sem Docker), execute o seguinte comando:

```./mvnw compile quarkus:dev```

Isso irá compilar o projeto e inicializar o Quarkus no modo de desenvolvimento, acessível em http://localhost:8180.

1.3. Criando a imagem Docker
Para criar a imagem Docker do seu projeto, basta rodar os seguintes comandos:

```mvn package -Dquarkus.package.type=legacy-jar ```

``` docker build -f src/main/docker/Dockerfile.legacy-jar -t sisacad-unifor:v1.0.0 .```

Isso irá construir a imagem Docker definida no projeto. Após o build, você pode rodar a aplicação dentro de um container Docker.

1.4. Rodando a aplicação no Docker
Depois de gerar a imagem Docker, execute o seguinte comando para rodar a aplicação:

```docker run -i -d --network net-unifor --rm -p 8180:8180 unifor-sisacad:v1.0.0 ```
ou rode diretamente puxando a aplicação do DockerHub

```docker run -i -d --network net-unifor --rm -p 8180:8180 ttuca123/testeunifor2025:latest```

Isso irá iniciar o container e você poderá acessar a aplicação em http://localhost:8180.

### 2 Configurando o keycloak

2.1 Execute a aplicação do keycloak no Docker na porta **8080** para não gerar conflito com a porta da aplicação **8180**
Utilize o seguinte comando para rodar a aplicação do Keycloak via Docker:

```>docker run -d -p 8080:8080 --name keycloak --network net-unifor -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin -v keycloak-data:/opt/keycloak/data quay.io/keycloak/keycloak:26.1.0 start-dev```

2.2 Execute o login no KeyCloak acessando a url *http://localhost:8080* utilizando as seguintes credenciais
- login: **admin**
- password: **admin**

📦 Estrutura de Permissões:
- Visão de administrador **admin**:
  - Incluir, excluir, atualizar e visualizar usuários
- Visão de coordenador de cursos **coord**:
  - Incluir, excluir, atualizar e visualizar os semestres, cursos e disciplinas;
  - Realizar a montagem da matriz curricular.
- Visão de professor **prof**
  - Visualizar a matriz curricular.
- Visão de aluno **aluno**
  - Visualizar a matriz curricular.


📦 Estrutura do Projeto:
- src/main/java: Contém o código fonte do seu serviço Quarkus.
- src/main/resources: Contém arquivos de configuração e outros recursos.
- Dockerfile: Arquivo para construir a imagem Docker do projeto.
- pom.xml: Arquivo de configuração Maven, incluindo dependências Quarkus e Docker.

🧑‍💻 Desenvolvimento
Caso deseje contribuir ou realizar modificações no projeto, basta clonar o repositório e seguir os passos descritos acima para rodar a aplicação localmente. Para criar uma nova feature ou corrigir algum bug, basta submeter um pull request.

🤖 Testes
Você pode rodar os testes do Quarkus localmente com o seguinte comando:

```./mvnw test```

Isso irá executar todos os testes definidos no seu projeto.

📄 Licença
Este projeto está licenciado sob a Licença MIT - consulte o arquivo LICENSE para mais detalhes.

Se você tiver alguma dúvida, sinta-se à vontade para abrir uma issue ou enviar um pull request! 😊


### Explicação:
- **Funcionalidade**: Explica o que o projeto faz de forma breve.
- **Requisitos**: Aponta as ferramentas necessárias para rodar o projeto.
- **Como rodar localmente**: Passos para rodar o projeto sem Docker e com Docker.
- **Estrutura do projeto**: Apresenta a estrutura de diretórios e arquivos importantes.
- **Testes**: Mostra como executar os testes de unidade.
- **Licença**: Indicação de licença para o repositório.
