package SAMPLE_COMP.COMP_NAME.utility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIUtil {

    public static String generateToken(String username, String password) {
        Response response = given()
                .accept(ContentType.JSON)
                .queryParam("username",username)
                .and()
                .queryParam("password",password)
                .when().get(Environment.API_BASEURL+"/api/authentication");

        String token =response.path("accessToken");

        return token;
    }

    public static String generateTokenByRole(String userType) {
        String token = given()
                .queryParams(returnCredentials(userType))
                .when().get(Environment.API_BASEURL+"/sign").prettyPeek().path("accessToken");

        return "Bearer " + token;
    }

    public static Map<String, String> returnCredentials(String userType) {
        String email = "";
        String password = "";

        switch (userType) {
            case "endUser":
                email = Environment.END_USER_USERNAME;
                password = Environment.END_USER_PASSWORD;
                break;

            case "admin":
                email = Environment.ADMIN_USERNAME;
                password = Environment.ADMIN_PASSWORD;
                break;
        }
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", email);
        credentials.put("password", password);

        return credentials;
    }
}
