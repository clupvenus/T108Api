package test;

import baseURL.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C14_Odev extends DummyBaseUrl {
    /*
    C14_Post_SoftAssertIleExpectedDataTesti
//https://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir POST
request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
Request Body
{
"status": "success",
"data": {
     "name": “Leyla",
     "salary": "1230",
      "age": "44",
      "id": 41
}
}
Response Body
{
    "status": "success",
    "data": {
        "data": {
            "name": "Leyla",
            "id": 41,
            "salary": "1230",
            "age": "44"
        },
        "status": "success",
        "id": 3787
    },
    "message": "Successfully! Record has been updated."
}
     */
    @Test
    public void put(){


        //https://dummy.restapiexample.com/api/v1/update/21
        //1-url ve reqBody hazirla
        specDummyBase.pathParams("pp1","api","pp2","v1","pp3","update","pp4",21);

        TestDataDummy ddummy=new TestDataDummy();
        JSONObject reqBody=ddummy.reqBody();
        System.out.println(reqBody.toString());

        //2- expected data hazirla
        JSONObject expBody=ddummy.expBody();
        System.out.println(expBody);

        //3-response i kaydet

        Response response=given().spec(specDummyBase).contentType(ContentType.JSON).body(reqBody.toString()).put("/{pp1}/{pp2}/{pp3}/{pp4}");
        response.prettyPeek();


        //4-Assertion

        JsonPath resPath = response.jsonPath();

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(resPath.get("status"),expBody.get("status"));
        softAssert.assertEquals(resPath.get("data.data.name"),expBody.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(resPath.get("data.data.salary"),expBody.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(resPath.get("data.data.age"),expBody.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(resPath.get("data.data.id"),expBody.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertTrue(resPath.get("message").equals("Successfully! Record has been updated."));
        softAssert.assertTrue(resPath.get("data.status").equals("success"));
        softAssert.assertAll();
    }
}