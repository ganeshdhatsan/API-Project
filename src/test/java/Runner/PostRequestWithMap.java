package Runner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PostRequestWithMap {
	
	/**
	 *   {
  "profile": {
    "bio": "Software developer with a passion for open-source projects.",
	"email": "john.doe@example.com",
    "isVerified": true,
    "createdAt": "2023-06-15T12:34:56Z",
    "roles": ["admin", "editor"]
    "socialLinks": [
      {
        "platform": "Twitter",
        "url": "https://twitter.com/johndoe",
        "username": "johndoe"
      },
      {
        "platform": "LinkedIn",
        "url": "https://linkedin.com/in/johndoe",
        "username": "johndoe"
      }
    ],
    "preferences": {
      "language": "en-US",
      "theme": "dark",
      "notifications": {
        "email": true,
        "sms": false,
        "push": {
          "enabled": true,
          "sound": "chime"
        }
      }
    }
  }
  }
 
	 * 
	 */

    public static void main(String[] args) {
        // Base URI for the API
        RestAssured.baseURI = "https://example.com/api";

        // Creating the JSON structure using Map
        Map<String, Object> profile = new HashMap<>();

        // Basic profile details
        profile.put("bio", "Software developer with a passion for open-source projects.");
        profile.put("email", "john.doe@example.com");
        profile.put("isVerified", true);
        profile.put("createdAt", "2023-06-15T12:34:56Z");
        profile.put("roles", Arrays.asList("admin", "editor"));

        // Adding social links
        Map<String, String> socialLink1 = new HashMap<>();
        socialLink1.put("platform", "Twitter");
        socialLink1.put("url", "https://twitter.com/johndoe");
        socialLink1.put("username", "johndoe");

        Map<String, String> socialLink2 = new HashMap<>();
        socialLink2.put("platform", "LinkedIn");
        socialLink2.put("url", "https://linkedin.com/in/johndoe");
        socialLink2.put("username", "johndoe");

        profile.put("socialLinks", Arrays.asList(socialLink1, socialLink2));

        // Adding preferences
        Map<String, Object> notifications = new HashMap<>();
        notifications.put("email", true);
        notifications.put("sms", false);

        Map<String, Object> push = new HashMap<>();
        push.put("enabled", true);
        push.put("sound", "chime");
        notifications.put("push", push);

        Map<String, Object> preferences = new HashMap<>();
        preferences.put("language", "en-US");
        preferences.put("theme", "dark");
        preferences.put("notifications", notifications);

        profile.put("preferences", preferences);

        // POST request with Map as the request body
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(profile) // Pass the Map as the request body
                .post("/profile");

        // Handling the response
        if (response.statusCode() == 200) {
            System.out.println("POST Request Successful!");
            System.out.println("Response: " + response.body().asString());
        } else {
            System.out.println("POST Request Failed. Status Code: " + response.statusCode());
            System.out.println("Error Response: " + response.body().asString());
        }
    }
}

