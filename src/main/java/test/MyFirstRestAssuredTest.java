package test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class MyFirstRestAssuredTest {

    @Test
    public static void getResponseBody() {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public static void postResponseBody() {

//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("name", "Samith" );
//        map.put("job", "CEO");
//        System.out.println(map);
//
//        JSONObject request = new JSONObject(map);

        JSONObject request = new JSONObject();

        request.put("name","Samith");
        request.put("job","CEO");

        System.out.println(request);
        System.out.println(request.toString());
    }
}