package youtube;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;



//import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class First {
	@Test
	public void testget() {
		RestAssured.baseURI="https://reqres.in/api/";
		RestAssured.given()
		   .get("users?page=2")
		   .then()
		   .statusCode(200)
		   .and()
		   .body("data[1].first_name", Matchers.equalTo("Lindsay"));
		
	}
	@Test
	public void testpost() {
		HashMap<String, Object> rp=new HashMap<>();
		rp.put("name", "ra");
		rp.put("job", "basic");
		RestAssured.baseURI="https://reqres.in/api/";
		RestAssured.given().contentType(ContentType.JSON).body(rp)
		   .when().post("users")
		   .then().statusCode(201).log().all();
		
	}

}
