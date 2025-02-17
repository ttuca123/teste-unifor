package br.edu.unifor.config;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(//
        tags = { //
                @Tag(name = "tutorial", description = "Exemplo de estudo."), //
                @Tag(name = "unifor", description = "Pessoas gostam de estudar.")//
        }, //
        info = @Info(//
                title = "Api para o sistema SISAcad-Unifor", //
                version = "1.0.0", //
                contact = @Contact(//
                        name = "Fale com o Aleatório", //
                        url = "https://github.com/lucasscharf")), //
        servers = { //
                @Server(url = "https://localhost:8180")//
        }) //
public class SwaggerConfigUnifor extends jakarta.ws.rs.core.Application {
}
