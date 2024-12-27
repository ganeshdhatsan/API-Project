package Practice;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PracticeRunner {
	/**
	 * {
  "user": {
    "id": 12345,
	"email": "john.doe@example.com",
	 "roles": ["admin","editor"]
    "name": {
      "first": "John",
      "last": "Doe"
    },
  },
  "profile": {
    "socialLinks": [
      {
        "platform": "Twitter",
        "url": "https://twitter.com/johndoe",
      },
      {
        "platform": "LinkedIn",
        "url": "https://linkedin.com/in/johndoe",
      }
    ],
    "preferences": {
      "language": "en-US",
      "notifications": {
        "email": true,
        "push": {
          "enabled": true,
        }
      }
    }
  },
  "transactions": [
    {
      "amount": 150.5,
      "currency": "USD",
      "status": "completed",
      "details": {
        "method": "credit_card",
      }
    },
    {
      "amount": 150.5,
      "currency": "USD",
      "status": "completed",
      "details": {
        "method": "credit_card",
      }
    }
  ],
  "metadata": {
    "ipAddress": "192.168.1.1",
    "lastLogin": "2024-12-24T18:00:00Z",
    "permissions": {
      "canDelete": false,
      "modules": ["dashboard", "reports", "settings"]
    }
  }
}
	 */

	@Test
	private void execution() {
		RestAssured.baseURI="";
		RestAssured.basePath="";
		
		//initializing
		RequestSpecification request=RestAssured.given();
		
		// passing header (single header)  -- header should be string is fine
		
//		request.header("","").header("","").header("","")
		
//		Header header = new Header("", "");
		
		// Adding headers
        Map<String, Object> headers = new LinkedHashMap();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer token123");
       
        headers.forEach((key, value) -> request.header(key, value));

        // Adding cookies
        Map<String, Object> cookies = new LinkedHashMap();
        cookies.put("sessionId", 12345);
        cookies.put("userToken", "abc123");

        // Adding query parameters
        Map<String, Object> queryParams = new LinkedHashMap();
        queryParams.put("page", 1);
        queryParams.put("size", 50);
        
        // adding request body
        
        Map<String,String> name = new LinkedHashMap<>();
        name.put("firstname","");
        name.put("lastname","");

        Map <String,Object> user = new LinkedHashMap<>();
        user.put("id","");
        user.put("email","");
        user.put("roles",List.of("",""));
        user.put("roles",Arrays.asList("",""));
        user.put("name",name);
        
        Map<String,Object> user1 = Map.of("id","","email","","roles",List.of("",""),"name",name);
        
        Map<String,Object> push= new LinkedHashMap();
        push.put("enabled",false);
         
         Map<String,Object> notifications= new LinkedHashMap();
        notifications.put("email",true);
        notifications.put("push",push);
         
        Map<String,Object> preferences= new LinkedHashMap();
        preferences.put("language","");
         preferences.put("notifications",notifications);
        
          Map<String,Object> socialLinks1 = new LinkedHashMap();
          socialLinks1.put("platform","");
          socialLinks1.put("url","");
         
         Map<String,Object> socialLinks2 = new LinkedHashMap();
         socialLinks2.put("platform","");
         socialLinks2.put("url","");
       
        Map<String,Object> profile = new LinkedHashMap();
        profile.put("SocialLinks",List.of(socialLinks1,socialLinks2));
        profile.put("Preferences",preferences);
        profile.put("Notifications",notifications);
        
        Map<String,Object> rootBody = new LinkedHashMap<>();
        rootBody.put("user", user);
        rootBody.put("profile", profile);
        
        Response response = request.contentType("")
        .headers(headers)
        .queryParams(queryParams)
        .cookies(cookies)
        .body(rootBody)
        .auth().preemptive().basic("username", "password")
        .auth().preemptive().oauth2("String Token")
        .log()
        .all()
        .post();
        File schemaFile= new File("");
        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();
        long responseTime = response.getTime();
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
        String header = response.getHeader("header Key");
        Headers responseHeaders = response.getHeaders();
        for(Header singleheader:responseHeaders) {
        	String keyHeader = singleheader.getName();
        	String valueHeader =singleheader.getValue();
        }
        String valueCookie=response.getCookie("cookie key");
        Map<String, String> responseCookies = response.getCookies();
        responseCookies.forEach((key,value)->{
        	System.out.println(key+" "+value);
        });
        String responseBodyString = response.getBody().asPrettyString();
        JsonPath path = new JsonPath(responseBodyString);
        String stringValue = path.getString("key");
        int integerValue = path.getInt("key");
        boolean booleanValue = path.getBoolean("key");
        double doubleValue = path.getDouble("key");
        List<Object> list = path.getList("key");
        
        
        
        
        
        
        
        
        
        


	}

}
