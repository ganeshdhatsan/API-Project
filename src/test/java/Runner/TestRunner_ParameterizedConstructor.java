package Runner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import POJO_with_Builder.Name;
import POJO_with_Builder.Profile;
import POJO_with_Builder.Root;
import POJO_with_Builder.SocialLink;
import POJO_with_Builder.User;

public class TestRunner_ParameterizedConstructor {
	
    public static void main(String[] args) {
        // Build Name
       POJO_with_ParameterizedConstructor.Name name = new POJO_with_ParameterizedConstructor.Name("","");

        // Build User
        POJO_with_ParameterizedConstructor.User user = 
//        		new POJO_with_ParameterizedConstructor.User(0, name, "", true, "", new ArrayList<>(Arrays.asList("","")));
//        		new POJO_with_ParameterizedConstructor.User(0, name, "", true, "", Arrays.asList("",""));
        		new POJO_with_ParameterizedConstructor.User(0, name, "", true, "", List.of("",""));
        
        SocialLink socialLink1 = new SocialLink.Builder()
                .setPlatform("Twitter")
                .setUrl("https://twitter.com/johndoe")
                .setUsername("johndoe")
                .build();

        SocialLink socialLink2 = new SocialLink.Builder()
                .setPlatform("LinkedIn")
                .setUrl("https://linkedin.com/in/johndoe")
                .setUsername("john-doe")
                .build();

        // Create Profile with SocialLinks and Preferences
       

        // Build Root
        
        // Send API Request
//        RestAssured.given()
//                .contentType(ContentType.JSON)
//                .body(root)
//                .when()
//                .post("https://api.example.com/endpoint")
//                .then()
//                .statusCode(200)
//                .log().all();
        
       
    }
}

