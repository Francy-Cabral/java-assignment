package pluralsight;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class BasicResponse {
	public static final String BaseURL ="https://api.github.com";
	@Test
	public void convinienceMethod() {
		Response response=RestAssured.get(BaseURL);
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getContentType(), "application/json; charset=utf-8");
	}
	
	@Test
	public void genericHeader() {
		Response response=RestAssured.get(BaseURL);
		assertEquals(response.getHeader("server"), "GitHub.com");
		assertEquals(response.getHeader("x-ratelimit-limit"), "60");
	}
	
	// simple method
	@Test
	public void basicValidate() {
		RestAssured.when()
		           .get(BaseURL)
		           .then()
		           .assertThat()
		           .statusCode(200)
		           .and()
		           .contentType(ContentType.JSON)
		           .and()
		           .assertThat()
		           .header("x-ratelimit-limit", "60");
	}
	@Test
	public void hamcrestMatchers() {
		RestAssured.get(BaseURL)
		           .then()
		           .assertThat()
		           .statusCode(200)
		           .and()
		           .statusCode(Matchers.lessThan(300))
		           .header("cache-control", Matchers.containsStringIgnoringCase("max-age=60"))
		           .time(Matchers.lessThan(2L), TimeUnit.SECONDS)
		           .header("etag", Matchers.notNullValue());
	}
	@Test
	public void complexhamcrestMatchers() {
		RestAssured.get(BaseURL)
		           .then()
		           .header("x-ratelimit-limit", Integer::parseInt, Matchers.equalToObject(60))
		           .header("x-ratelimit-limit", response -> Matchers.greaterThan(response.header("x-ratelimit-remaining")));
	}

	        

}
