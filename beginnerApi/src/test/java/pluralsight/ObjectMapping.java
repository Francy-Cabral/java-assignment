package pluralsight;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import plural.User;

public class ObjectMapping {
	public static final String BaseURL ="https://api.github.com/users/rest-assured";
	
	@Test
	public void objTest() {
		User user= RestAssured.get(BaseURL)
				.as(User.class);
		assertEquals(user.getLogin(), "rest-assured");
		assertEquals(user.getId(), 19369327);
		assertEquals(user.getPublicRepos(), 2);
	}

}
