package pluralsight;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
	public static final String BaseURL ="https://api.github.com/";
	@Test
	public void test() {
		RestAssured
		    .given()
		        .spec(getDefaultRequestSpec())
		    .when()
		         .get()
		    .then()
		         .statusCode(200);
	}
	public static RequestSpecification getDefaultRequestSpec() {
		// TODO Auto-generated method stub
		return new RequestSpecBuilder()
				.setBaseUri(BaseURL)
				.build();
	}

}
