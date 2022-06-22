package pluralsight;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class BodyFirst {
	public static final String BaseURL ="https://api.github.com/rate_limit";
	@Test
	public void jsonPathReturnsMap() {
		Response response= RestAssured.get(BaseURL);
		ResponseBody<?> body=response.body();
		JsonPath jPath = body.jsonPath();
		JsonPath jPath2 = response.body().jsonPath();
		Map<String, String> fullJson;
		fullJson=jPath2.get();
		Map<String, String> subMap;
		subMap=jPath2.get("resources");
		Map<String, String> subMap2;
		subMap2=jPath2.get("resources.core");
		
		int value =jPath.get("resources.core.limit");
		int value2 =jPath.get("resources.graphql.remaining");
	}
	@Test
	public void nestedBody() {
		RestAssured.get(BaseURL)
		      .then()
		      .rootPath("resources.core")
		          .body("limit", Matchers.equalTo(60))
		          .body("remaining",Matchers.lessThanOrEqualTo(60))
		      .rootPath("resources.search")
		           .body("limit", Matchers.equalTo(10))
		           .body("remaining",Matchers.lessThanOrEqualTo(10))
		      .noRootPath()
		           .body("resources.graphql.limit", Matchers.is(0));
	}

}
