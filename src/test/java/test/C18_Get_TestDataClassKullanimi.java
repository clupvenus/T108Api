package test;

import baseURL.JsonHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testData.TestDataPlaceHolder;

import static io.restassured.RestAssured.given;

public class C18_Get_TestDataClassKullanimi extends JsonHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
yolladigimizda donen response’in status kodunun 200 ve response body’sinin
asagida verilen ile ayni oldugunutest ediniz
Response body :
{
"userId": 3,
"id": 22,
"title": "dolor sint quo a velit explicabo quia nam",
"body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
     */
    @Test
    public void get01(){
     /*
      https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
yolladigimizda donen response’in status kodunun 200 ve response body’sinin
asagida verilen ile ayni oldugunutest ediniz
      */
        //1-url hazirla
        specJSonHolder.pathParams("pp1","posts","pp2",22);
        //2-expected data
        TestDataPlaceHolder dataPlaceHolder=new TestDataPlaceHolder();
        JSONObject expectedData=dataPlaceHolder.expDataOlustur();
        //3-response a kaydet
        Response response=given().spec(specJSonHolder)
                          .when().get("/{pp1}/{pp2}");
        response.prettyPrint();
        //4-Assertion
        JsonPath resJPath=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(resJPath.get("userId"),expectedData.get("userId"));
        softAssert.assertEquals(resJPath.get("id"),expectedData.get("id"));
        softAssert.assertEquals(resJPath.get("title"),expectedData.get("title"));
        softAssert.assertEquals(resJPath.get("body"),expectedData.get("body"));
        softAssert.assertEquals(response.statusCode(),dataPlaceHolder.basariliStatuskodu);
        softAssert.assertAll();




    }

}
