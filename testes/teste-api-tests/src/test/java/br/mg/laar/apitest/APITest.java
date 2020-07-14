package br.mg.laar.apitest;

import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APITest {

	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "http://206.189.178.48:7000/api";
	}
    

    @Test
    public void deveRetornarUsuarios() {
    	RestAssured.given()
    	.when()
    		.get("/api")
    	.then()
    		.statusCode(200)
    	;
    }
    
    @Test
    public void deveAdicionarUsuarioComSucesso() {
    	RestAssured.given()
    		.body("{\"nome\": \"Joao da Silva\", \"email\": \"joao@gmail.com\", \"senha\": \"123456789\", \"confirmacao\": \"123456789\"}")
    		.contentType(ContentType.JSON)
    	.when()
    		.post("/api")
    	.then()
    		.statusCode(201)
    	;
    }
    
    @Test
    public void camposSemValidaçãoDeObricatoriedade() {
    	RestAssured.given()
    		.body("{\"nome\": \"Joao da Silva\", \"email\": \"joao@gmail.com\", \"senha\": \"123456789\", \"confirmacao\": \"123456789\"}")
    		.contentType(ContentType.JSON)
    	.when()
    		.post("/api")
    	.then()
    		.statusCode(400)
    		.body("message", CoreMatchers.is("Os campos são obrigatórios"))
    	;
    }
    
    @Test
    public void naoDeveSerPermitidoEmailRepetido() {
    	RestAssured.given()
    		.body("{\"nome\": \"Jose da Silva\", \"email\": \"joao@gmail.com\", \"senha\": \"123456\", \"confirmacao\": \"123456\"}")
    		.contentType(ContentType.JSON)
    	.when()
    		.post("/api")
    	.then()
    		.statusCode(409)
    		.body("message", CoreMatchers.is("Não é permitido cadastrar e-mails repetidos na base"))
    	;
    }
    
    @Test
    public void senhaMinimoSeisCaracteres() {
    	RestAssured.given()
    		.body("{\"nome\": \"Mario da Silva\", \"email\": \"mario@gmail.com\", \"senha\": \"12345\", \"confirmacao\": \"123456\"}")
    		.contentType(ContentType.JSON)
    	.when()
    		.post("/api")
    	.then()
    		.statusCode(400)
    		.body("message", CoreMatchers.is("Senha deve ter no mínimo 6 caracteres"))
    	;
    }
    
    @Test
    public void removerIdNaoEncontrado() {
    	RestAssured.given()
    		.body("{\"nome\": \" \", \"email\": \" \", \"senha\": \" \", \"confirmacao\": \" \"}")
    		.contentType(ContentType.JSON)
    	.when()
    		.delete("/api")
    	.then()
    		.statusCode(404)
    		.body("message", CoreMatchers.is("Usuario não encontrado"))
    	;
    }
}