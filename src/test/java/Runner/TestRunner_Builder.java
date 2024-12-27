package Runner;


import java.util.Arrays;

import POJO_with_Builder.Name;
import POJO_with_Builder.Profile;
import POJO_with_Builder.Root;
import POJO_with_Builder.SocialLink;
import POJO_with_Builder.User;

public class TestRunner_Builder {
	
    public static void main(String[] args) {
        // Build Name
        Name name = new Name.Builder()
                .setFirst("John")
                .setLast("Doe")
                .build();

        // Build User
        User user = new User.Builder()
                .setId(12345)
                .setName(name)
                .setEmail("john.doe@example.com")
                .setVerified(true)
                .setCreatedAt("2023-06-15T12:34:56Z")
                .setRoles(Arrays.asList("admin", "editor"))
                .build();
        
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
        Profile profile = new Profile.Builder()
                .setBio("Software engineer passionate about open-source projects.")
                .setSocialLinks(Arrays.asList(socialLink1, socialLink2))
                .build();

        // Build Root
        Root root = new Root.Builder()
                .setUser(user)
                .setProfile(profile)
                .build();

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

