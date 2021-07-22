package token;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TokenTest {

    public static String redirectUri = "https://qa.eshrewd.net/auth-service/oauth/token";
    public static String clientId = "trusted";
    public static String clientSecret = "secret";
    public static String username = "Diego";
    public static String password = "test";

    @Test
    public void getOauthTest(){
        baseURI = "https://qa.eshrewd.net/auth-service";
        Response response =
                given().auth().preemptive().basic(clientId,clientSecret)
                        .contentType("application/x-www-form-urlencoded").log().all()
                        .formParam("grant_type", "password")
                        .formParam("username", username)
                        .formParam("password", password)
                        .when()
                        .post("/oauth/token");

        String accessToken = response.getBody().path("access_token").toString();
        String tokenType = response.getBody().path("token_type").toString();

        String token = tokenType + " " + accessToken;
        System.out.println("Oauth Token ::: \n" + token);
    }
}