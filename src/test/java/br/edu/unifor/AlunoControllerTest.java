package br.edu.unifor;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AlunoControllerTest {



    void testObterAlunoValidoEndpoint() {
        given()
                .when().get("/v1/alunos")
                .then()
                .statusCode(200);
                //.body(is("Hello from Quarkus REST"));
    }
}
