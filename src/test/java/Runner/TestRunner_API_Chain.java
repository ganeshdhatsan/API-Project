package Runner;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestRunner_API_Chain {

	private static final Logger logger = LoggerFactory.getLogger(TestRunner_API_Chain.class);
	private static final String BASE_URL = "https://example.com/api"; // Base URL for the API
	private static String authToken = null; // Declare authToken as a single variable
	private static String userId = null; // Declare userId as a single variable

	/**
	 * Step 1: Authenticate and get the token.
	 */
	private String getAuthToken() {
		try {
			Map<String, String> authPayload = new HashMap<>();
			authPayload.put("username", "user");
			authPayload.put("password", "pass");

			logger.info("Requesting authentication token...");
			Response response = RestAssured.given().contentType("application/json").body(authPayload)
					.post("/authenticate");

			if (response.statusCode() == 200) {
				String token = response.jsonPath().getString("token");
				logger.info("Authentication successful. Token: {}", token);
				return token;
			} else {
				logger.error("Authentication failed. Status Code: {}, Response: {}", response.statusCode(),
						response.body().asString());
			}
		} catch (Exception e) {
			logger.error("Error during authentication: {}", e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Step 2: Get user details using the authentication token.
	 */
	private String getUserDetails() {
		try {
			logger.info("Fetching user details...");
			Response response = RestAssured.given().header("Authorization", "Bearer " + authToken).get("/user/details");

			if (response.statusCode() == 200) {
				String userId = response.jsonPath().getString("userId");
				logger.info("User details retrieved successfully. User ID: {}", userId);
				return userId;
			} else if (response.statusCode() == 401) {
				logger.warn("Token expired. Refreshing token...");
				authToken = getAuthToken();
				if (authToken != null) {
					return getUserDetails(); // Retry with refreshed token
				}
			} else {
				logger.error("Failed to fetch user details. Status Code: {}, Response: {}", response.statusCode(),
						response.body().asString());
			}
		} catch (Exception e) {
			logger.error("Error fetching user details: {}", e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Step 3: Fetch user posts using the user ID.
	 */
	private void getUserPosts(String userId) {
		try {
			logger.info("Fetching posts for user ID: {}", userId);
			Response response = RestAssured.given().header("Authorization", "Bearer " + authToken) // Include auth
																									// header
					.get("/user/" + userId + "/posts");

			if (response.statusCode() == 200) {
				logger.info("User posts retrieved successfully: {}", response.body().asString());
			} else {
				logger.error("Failed to fetch user posts. Status Code: {}, Response: {}", response.statusCode(),
						response.body().asString());
			}
		} catch (Exception e) {
			logger.error("Error fetching user posts: {}", e.getMessage(), e);
		}
	}

	/**
	 * Main execution method for the test.
	 */
	@Test
	public void execute() {
		// Set the base URI for RestAssured
		RestAssured.baseURI = BASE_URL;

		// Step 1: Get Authentication Token
		authToken = getAuthToken();
		if (authToken == null) {
			logger.error("Authentication failed. Terminating API chaining.");
			return;
		}

		// Step 2: Fetch user details
		userId = getUserDetails();
		if (userId == null) {
			logger.error("Failed to fetch user details. Terminating API chaining.");
			return;
		}

		// Step 3: Fetch user posts
		getUserPosts(userId);
	}
}
