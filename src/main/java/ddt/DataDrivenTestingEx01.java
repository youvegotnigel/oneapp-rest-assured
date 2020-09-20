package ddt;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DataDrivenTestingEx01 extends DataProvider {


    @Test (dataProvider = "dataForPost")
    public void test_post(String subject_key, String subject, String shift_id) {

        JSONObject request = new JSONObject();
        baseURI = "https://oneapp.ncinga.com";

        request.put("subject_key", subject_key);
        request.put("subject", subject);
        request.put("shift_id", shift_id);

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
}
