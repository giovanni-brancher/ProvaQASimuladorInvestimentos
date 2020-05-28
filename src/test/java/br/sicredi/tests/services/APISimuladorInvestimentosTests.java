package br.sicredi.tests.services;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

/**
 * Classe de testes da API do Simulador de Investimentos - Poupança Sicredi.
 * 
 * @author Giovanni D. Brancher
 */
public class APISimuladorInvestimentosTests {

	/**
	 * Deve verificar e validar o response da requisição realizada.
	 * 
	 */
	@Test
	public void deveValidarValoresResponse() {
		given()
		.when()
			.get("http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body("id", is(1))
			.body("meses", hasSize(4))
			.body("meses", hasItems("112", "124", "136", "148"))
			.body("valor", hasSize(4))
			.body("valor", hasItems("2.802", "3.174", "3.564", "3.971"))
		;
	}
	
	/**
	 * Deve validar o schema do JSON retornado.
	 * 
	 */
	@Test
	public void deveValidarSchemaJson() {
		given()
		.when()
			.get("http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("simulador.json"))
		;
	}
	
	/**
	 * Não deve retornar um JSON ao tentar enviar valores via URL para o recurso.
	 * 
	 */
	@Test
	public void naoDeveEncontrarJsonEnviandoIdPelaUrl() {
		given()
			.pathParam("id", "1")
		.when()
			.get("http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador/{id}")
		.then()
			.statusCode(404)
			.body(containsString("Not found"))
		;
	}
}
