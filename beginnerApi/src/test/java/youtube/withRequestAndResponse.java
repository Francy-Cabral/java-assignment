package youtube;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class withRequestAndResponse {
	RequestSpecification reqSpec = RestAssured.given()
			.baseUri("https://reqres.in/api/")
			.header("Content-Type", "application/json");
	ResponseSpecification resSpec= new ResponseSpecBuilder()
			.expectStatusCode(200)
			.expectContentType(ContentType.JSON)
			.build();
	
	@Test
	public void TestGet() {
		RestAssured.given()
		.spec(reqSpec)
		.get("users?page=2")
		.then()
		.spec(resSpec)
		.and()
		.body("data[1].first_name", Matchers.equalTo("Lindsay"));
		
	}
	@Test
	public void TestPost() {
		JSONObject reqParams= new JSONObject();
		reqParams.put("name", "eli");
		reqParams.put("job", "manager");
		RestAssured.given()
		.spec(reqSpec)
		.body(reqParams.toJSONString())
	      .when()
	      .post("users")
	      .then()
	      .statusCode(201).log().all();
	}
	
	@Test
	public void putAndDelete() {
		RestAssured.baseURI="https://reqres.in/api/";
		HashMap<String, Object> rp=new HashMap<>();
		rp.put("name", "ra");
		rp.put("job", "basic");
		RestAssured.baseURI="https://reqres.in/api/";
		RestAssured.given()
		   .spec(reqSpec)
		   .body(rp)
		   .when().post("users")
		   .then().statusCode(201).log().all();
		String productId=RestAssured.given()
				.spec(reqSpec)
				.body(rp)
	      		   .when().post("users")
				   .then()
				   .extract().path("id");
		rp.put("name", "ra");
		rp.put("job", "level up");
		RestAssured.given()
		.spec(reqSpec)
		.body(rp)
		   .when().put("users/"+productId)
		   .then()
		   .spec(resSpec)
		   .log().all();
		RestAssured.given().contentType(ContentType.JSON).body(rp)
		   .when().delete("users/"+productId);
		RestAssured.given().when().get("users/"+productId).then().statusCode(404);
	}

}
