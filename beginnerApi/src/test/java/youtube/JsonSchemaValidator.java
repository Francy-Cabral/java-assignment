package youtube;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class JsonSchemaValidator {
	@Test
	public void testget() {
		RestAssured.baseURI="https://reqres.in/api/";
		RestAssured.given()
		   .get("users?page=2")
		   .then()
		   .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
		   .statusCode(200);
		   
	}

}
