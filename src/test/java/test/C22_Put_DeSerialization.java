package test;


import baseURL.JsonHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.TestDataPlaceHolder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C22_Put_DeSerialization extends JsonHolderBaseUrl {
    /*
  https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
PUT request yolladigimizda donen response’in response body’sinin asagida
verilen ile ayni oldugunu test ediniz
DE-SERIALIZATION ILE EXPECTED DATA TESTI
Expected Data :
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70

     */
    @Test
    public void put01(){
        //1- URL ve body hazirla
        specJSonHolder.pathParams("pp1","posts","pp2",70);
        TestDataPlaceHolder testDataPlaceHolder=new TestDataPlaceHolder();
        Map<String,Object> reqBody =testDataPlaceHolder.reqBodyOlustur();

        //2-Expected Data
        Map<String,Object> expBodyMap =testDataPlaceHolder.reqBodyOlustur();

        //3- Response KAydet

        Response response=given()
                              .spec(specJSonHolder)
                              .contentType(ContentType.JSON)
                          .when()
                              .body(reqBody)//map oldugu icin toString yapmadik
                              .put("/{pp1}/{pp2}");

        //4- Assertion
        HashMap <String,Object>respMap = response.as(HashMap.class);//responsemizi JasonPathe degilHashMap e cevirdik yani de-serialization yaptik
        assertEquals(testDataPlaceHolder.basariliStatuskodu,response.getStatusCode());
        assertEquals(expBodyMap.get("title"),respMap.get("title"));
        assertEquals(expBodyMap.get("id"),respMap.get("id"));
        assertEquals(expBodyMap.get("body"),respMap.get("body"));
        assertEquals(expBodyMap.get("userId"),respMap.get("userId"));
        //map int ifadeleri double olarak doner bu nedenle 70.0 seklinde yazdik Map e




    }

}
