package test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class StaticImports {

    @Test
    public void test_01() {

        Response response = get("https://reqres.in/api/users?page=2");

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
    public void test_02(){

        given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7));
        //given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[1]", equalTo(8)).log().all();
        given().get("https://reqres.in/api/users?page=2").then().
                statusCode(200).body("data.id[1]", equalTo(8)).
                body("data.first_name",hasItems("Tobias","Lindsay","Rachel"));
                //body();
    }

    @Test
    public void test_03(){

        JSONObject request = new JSONObject();

        request.put("name","Samith");
        request.put("job","CEO");

        given().body(request.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201);
    }

    @Test
    public void test_04(){

        JSONObject request = new JSONObject();
        baseURI = "https://oneapp.ncinga.com";

        request.put("subject_key","ant-aal-aepz");
        request.put("subject","ant-aal-aepz");
        request.put("shift_id","8_5shift_D_2020-09-19");

        given().
                body(request.toJSONString()).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                post("/shift_services/v2/getschedule").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_05(){

        JSONObject request = new JSONObject();
        baseURI = "https://oneapp.ncinga.com";

        request.put("subject_key","ant-aal-aepz");

        given().
                body(request.toJSONString()).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                post("/shift_services/v2/getshifts").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_06(){

        JSONObject request = new JSONObject();
        baseURI = "https://nfactorylive.ncinga.com";

        request.put("subject_key","mfg-cls-ftry");
        request.put("date","2020-09-19");

        given().
                body(request.toJSONString()).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                post("/app_shift_services/v2/getschedulesforsubjectkey").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void sclTokenTest(){

        JSONObject request = new JSONObject();
        baseURI = "https://oneapp.ncinga.com";

        request.put("username","Zilingo");
        request.put("password","upb6k7");
        request.put("type","auth");

        given().header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/rest_services/post_service").
                then().
                statusCode(200);

        given().header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("https://oneapp.ncinga.com/rest_services/post_service").
                then().
                statusCode(200).log().all();
    }
}
