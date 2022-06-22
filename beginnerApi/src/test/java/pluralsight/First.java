package pluralsight;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class First {
	// update status
	/*@Test
	public void someTest() {
		RestAssured.get("https://reqres.in/")
		        .then()
		        .statusCode(200);
	} */
	// to get response
	public static final String BaseURL ="https://api.github.com";
	@Test
	public void peek() {
		RestAssured.get(BaseURL)
		           .peek();
	}
	@Test
	public void prettypeek() {
		RestAssured.get(BaseURL)
		           .prettyPeek();
	}
	@Test
	public void print() {
		RestAssured.get(BaseURL)
		           .print();
	}
	@Test
	public void prettyprint() {
		RestAssured.get(BaseURL)
		           .prettyPrint();
	}

}
