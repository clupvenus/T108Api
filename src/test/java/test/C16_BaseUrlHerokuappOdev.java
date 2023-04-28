package test;

import baseURL.HerOkuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testData.TestDataHerOku;

import static io.restassured.RestAssured.given;

public class C16_BaseUrlHerokuappOdev extends HerOkuBaseUrl {
    /*
    Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin
      1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
      gonderdigimizde donen response’un status code’unun 200 oldugunu ve
      Response’ta 12 booking oldugunu test edin

            2- https://restful-booker.herokuapp.com/booking
            endpointine asagidaki body’ye sahip bir POST
            request gonderdigimizde donen response’un
            status code’unun 200 oldugunu ve “firstname”
            degerinin “Ahmet” oldugunu test edin
            {
        "firstname" : "Ahmet",
        "lastname" : “Bulut",
            "talprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
            },
            "additionalneeds" : "wi-fi"
            }
                 */
    @Test
    public void get01(){
     /*   1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve
        Response’ta 12 booking oldugunu test edin
       */
        //1-url hazirla
        specHerOku.pathParam("pp1","booking");

        //2- exp data hazirla
       //3-response i kaydet
        Response response=given().spec(specHerOku).when().get("/{pp1}");
        response.prettyPrint();
        //4-Assertion

        response.then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(12));
    }
    @Test
    public void get02(){
        /*
          2- https://restful-booker.herokuapp.com/booking endpointine asagidaki body’ye sahip bir POST
            request gonderdigimizde donen response’un status code’unun 200 oldugunu ve “firstname”
            degerinin “Ahmet” oldugunu test edin
            {
        "firstname" : "Ahmet",
        "lastname" : “Bulut",
            "talprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
            },
            "additionalneeds" : "wi-fi"
            }
         */
        //1-url ve req body hazirla
        specHerOku.pathParam("pp1","booking");
        TestDataHerOku herOku=new TestDataHerOku();
        JSONObject reqBody= herOku.reqBodyHerOkuPost();

        //2-expected data

        TestDataHerOku expData=new TestDataHerOku();
        JSONObject expectData=expData.expDateHerOkuPost();
        System.out.println("expectData = " + expectData);
        //3-response kaydet

        Response response=given().spec(specHerOku)
                                 .contentType(ContentType.JSON)
                         .when().body(reqBody.toString())
                         .post("/{pp1}");
        response.prettyPrint();

        //4-Assertion
        SoftAssert softAssert=new SoftAssert();
        JsonPath respjsonPath=response.jsonPath();
        softAssert.assertEquals(respjsonPath.get("booking.firstname"),expectData.get("firstname"));
        softAssert.assertEquals(response.statusCode(),herOku.basariliStatusKodu);
        softAssert.assertAll();




    }




}
