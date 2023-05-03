package test;

import PojoS.PojoJsonPlaceHolder;
import baseURL.JsonHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.util.Asserts;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C25_Put_PojoClass extends JsonHolderBaseUrl {
    /*
    C27_Put_PojoClass
https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
PUT request yolladigimizda donen response’in response body’sinin asagida
verilen ile ayni oldugunu test ediniz
POJO CLASS ILE EXPECTED DATA TESTI
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
    public void posts01(){
        //1- url ve body hazirla.
        specJSonHolder.pathParams("pp1","posts","pp2",70);
        PojoJsonPlaceHolder reqBody=new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);
        //2- expected data
        PojoJsonPlaceHolder expbody=reqBody;
        //3-Response kaydet
        Response response=given().spec(specJSonHolder).contentType(ContentType.JSON)
                         .when().body(reqBody).post("/{pp1}/{pp2}");
        //4-Assertion
        PojoJsonPlaceHolder resPojo=response.as(PojoJsonPlaceHolder.class);
        assertEquals(resPojo.getTitle(),expbody.getTitle());




    }
}
