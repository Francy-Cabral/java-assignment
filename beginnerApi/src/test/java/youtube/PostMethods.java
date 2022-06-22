package youtube;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
//import io.restassured.internal.util.IOUtils;
import io.restassured.response.ValidatableResponse;

public class PostMethods {
	
	//using Json object
	@Test
	public void post1() {
		RestAssured.baseURI="https://reqres.in/api/";
		
		JSONObject reqParams= new JSONObject();
		reqParams.put("name", "eli");
		reqParams.put("job", "manager");
		RestAssured.given()
		      .header("Content-Type", "application/json")
		      .body(reqParams.toJSONString())
		      .when()
		      .post("users")
		      .then()
		      .statusCode(201).log().all();
	}
	//using String
	@Test
	public void post2() {
		RestAssured.baseURI="https://reqres.in/api/";
		String rp="{\r\n" + 
				"    \"name\": \"meu\",\r\n" + 
				"    \"job\": \"lead\"\r\n" + 
				"}";
		RestAssured.given()
	      .header("Content-Type", "application/json")
	      .body(rp)
	      .when()
	      .post("users")
	      .then()
	      .statusCode(201).log().all();
	}
	
	//using json file
	@Test
	public void post3() throws Exception {
		RestAssured.baseURI="https://reqres.in/api/";
		FileInputStream FIS= new FileInputStream(new File(".\\demoJson\\file1.json"));
		RestAssured.given()
		  .header("Content-Type", "application/json")
	      .body(IOUtils.toString(FIS,"UTF-8"))
	      .when()
	      .post("users")
	      .then()
	      .statusCode(201).log().all();
	}
	
	//using java object
	@Test
	public void post4() {
		RestAssured.baseURI="https://reqres.in/api/";
		HashMap<String, Object> rp=new HashMap<>();
		rp.put("name", "ra");
		rp.put("job", "basic");
		RestAssured.baseURI="https://reqres.in/api/";
		RestAssured.given().contentType(ContentType.JSON).body(rp)
		   .when().post("users")
		   .then().statusCode(201).log().all();
	}
	
	@Test
	public void putAndDelete() {
		RestAssured.baseURI="https://reqres.in/api/";
		HashMap<String, Object> rp=new HashMap<>();
		rp.put("name", "ra");
		rp.put("job", "basic");
		RestAssured.baseURI="https://reqres.in/api/";
		RestAssured.given().contentType(ContentType.JSON).body(rp)
		   .when().post("users")
		   .then().statusCode(201).log().all();
		String productId=RestAssured.given().contentType(ContentType.JSON).body(rp)
	      		   .when().post("users")
				   .then()
				   .extract().path("id");
		rp.put("name", "ra");
		rp.put("job", "level up");
		RestAssured.given().contentType(ContentType.JSON).body(rp)
		   .when().put("users/"+productId)
		   .then().statusCode(200).log().all();
		RestAssured.given().contentType(ContentType.JSON).body(rp)
		   .when().delete("users/"+productId);
		RestAssured.given().when().get("users/"+productId).then().statusCode(404);
	}
	


}
