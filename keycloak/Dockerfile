# Usa a imagem oficial do Keycloak como base
FROM quay.io/keycloak/keycloak:26.1.0

# Definir variáveis de ambiente
ENV KC_BOOTSTRAP_ADMIN_USERNAME=admin
ENV KC_BOOTSTRAP_ADMIN_PASSWORD=admin

# Configura o diretório de dados do Keycloak
VOLUME /opt/keycloak/data

# Expõe a porta 8080
EXPOSE 8080

# Comando que será executado quando o container for iniciado
CMD ["start-dev"]
