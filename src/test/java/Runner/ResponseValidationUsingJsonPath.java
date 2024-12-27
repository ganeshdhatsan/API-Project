package Runner;

import java.util.Arrays;

import org.testng.Assert;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ResponseValidationUsingJsonPath {
	public void responseValidatio(){
	String jsonResponse = "{\r\n"
			+ "  \"user\": {\r\n"
			+ "    \"id\": 12345,\r\n"
			+ "    \"name\": {\r\n"
			+ "      \"first\": \"John\",\r\n"
			+ "      \"last\": \"Doe\"\r\n"
			+ "    },\r\n"
			+ "    \"email\": \"john.doe@example.com\",\r\n"
			+ "    \"isVerified\": true,\r\n"
			+ "    \"createdAt\": \"2023-06-15T12:34:56Z\",\r\n"
			+ "    \"roles\": [\"admin\", \"editor\"]\r\n"
			+ "  },\r\n"
			+ "  \"profile\": {\r\n"
			+ "    \"bio\": \"Software developer with a passion for open-source projects.\",\r\n"
			+ "    \"socialLinks\": [\r\n"
			+ "      {\r\n"
			+ "        \"platform\": \"Twitter\",\r\n"
			+ "        \"url\": \"https://twitter.com/johndoe\",\r\n"
			+ "        \"username\": \"johndoe\"\r\n"
			+ "      },\r\n"
			+ "      {\r\n"
			+ "        \"platform\": \"LinkedIn\",\r\n"
			+ "        \"url\": \"https://linkedin.com/in/johndoe\",\r\n"
			+ "        \"username\": \"johndoe\"\r\n"
			+ "      }\r\n"
			+ "    ],\r\n"
			+ "    \"preferences\": {\r\n"
			+ "      \"language\": \"en-US\",\r\n"
			+ "      \"theme\": \"dark\",\r\n"
			+ "      \"notifications\": {\r\n"
			+ "        \"email\": true,\r\n"
			+ "        \"sms\": false,\r\n"
			+ "        \"push\": {\r\n"
			+ "          \"enabled\": true,\r\n"
			+ "          \"sound\": \"chime\"\r\n"
			+ "        }\r\n"
			+ "      }\r\n"
			+ "    }\r\n"
			+ "  },\r\n"
			+ "  \"transactions\": [\r\n"
			+ "    {\r\n"
			+ "      \"id\": \"tx1001\",\r\n"
			+ "      \"amount\": 150.5,\r\n"
			+ "      \"currency\": \"USD\",\r\n"
			+ "      \"date\": \"2024-12-25T08:00:00Z\",\r\n"
			+ "      \"status\": \"completed\",\r\n"
			+ "      \"details\": {\r\n"
			+ "        \"method\": \"credit_card\",\r\n"
			+ "        \"last4\": \"1234\",\r\n"
			+ "        \"issuer\": \"Visa\"\r\n"
			+ "      }\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"id\": \"tx1002\",\r\n"
			+ "      \"amount\": 75.0,\r\n"
			+ "      \"currency\": \"USD\",\r\n"
			+ "      \"date\": \"2024-12-20T14:30:00Z\",\r\n"
			+ "      \"status\": \"pending\",\r\n"
			+ "      \"details\": {\r\n"
			+ "        \"method\": \"paypal\",\r\n"
			+ "        \"email\": \"paypal-user@example.com\"\r\n"
			+ "      }\r\n"
			+ "    }\r\n"
			+ "  ],\r\n"
			+ "  \"metadata\": {\r\n"
			+ "    \"ipAddress\": \"192.168.1.1\",\r\n"
			+ "    \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36\",\r\n"
			+ "    \"lastLogin\": \"2024-12-24T18:00:00Z\",\r\n"
			+ "    \"permissions\": {\r\n"
			+ "      \"canEdit\": true,\r\n"
			+ "      \"canDelete\": false,\r\n"
			+ "      \"modules\": [\"dashboard\", \"reports\", \"settings\"]\r\n"
			+ "    }\r\n"
			+ "  }\r\n"
			+ "}";
	
	Response response=null;

        // Parse the JSON response
        JsonPath jsonPath = new JsonPath(jsonResponse);

        // Validate User data 
        Assert.assertEquals(jsonPath.getInt("user.id"), 12345, "User ID does not match!");
        Assert.assertEquals(jsonPath.getString("user.name.first"), "John", "User first name does not match!");
        Assert.assertEquals(jsonPath.getString("user.name.last"), "Doe", "User last name does not match!");
        Assert.assertEquals(jsonPath.getString("user.email"), "john.doe@example.com", "User email does not match!");
        Assert.assertTrue(jsonPath.getBoolean("user.isVerified"), "User isVerified flag does not match!");
        Assert.assertEquals(jsonPath.getList("user.roles"), Arrays.asList("admin", "editor"), "User roles do not match!");
        
        // Validate Profile data
        Assert.assertEquals(jsonPath.getString("profile.bio"), "Software developer with a passion for open-source projects.", "Profile bio does not match!");
        Assert.assertEquals(jsonPath.getString("profile.socialLinks[0].platform"), "Twitter", "Social link 1 platform does not match!");
        Assert.assertEquals(jsonPath.getString("profile.socialLinks[1].url"), "https://linkedin.com/in/johndoe", "Social link 2 URL does not match!");
        
        // Validate Preferences
        Assert.assertEquals(jsonPath.getString("profile.preferences.language"), "en-US", "Preference language does not match!");
        Assert.assertEquals(jsonPath.getString("profile.preferences.notifications.push.sound"), "chime", "Push notification sound does not match!");
        
        // Validate Transactions
        Assert.assertEquals(jsonPath.getString("transactions[0].id"), "tx1001", "Transaction 1 ID does not match!");
        Assert.assertEquals(jsonPath.getFloat("transactions[0].amount"), 150.5f, "Transaction 1 amount does not match!");
        Assert.assertEquals(jsonPath.getString("transactions[1].details.method"), "paypal", "Transaction 2 method does not match!");
       
        // Validate Metadata
        Assert.assertEquals(jsonPath.getString("metadata.ipAddress"), "192.168.1.1", "IP Address does not match!");
        Assert.assertTrue(jsonPath.getBoolean("metadata.permissions.canEdit"), "Permission canEdit does not match!");
        Assert.assertEquals(jsonPath.getList("metadata.permissions.modules"), Arrays.asList("dashboard", "reports", "settings"), "Modules do not match!");
        
        //schema validation
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("userSchema.json"));
        System.out.println("All validations passed!");
    }
}
