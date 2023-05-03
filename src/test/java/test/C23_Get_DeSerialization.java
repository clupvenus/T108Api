package test;

import baseURL.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import testData.TestDataDummy;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C23_Get_DeSerialization extends DummyBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
gonderdigimizde donen response’un status code’unun 200, content Type’inin
application/json ve body’sinin asagidaki gibi oldugunu test edin.
Response Body
{
"status": "success",
"data": {
"id": 3,
"employee_name": "Ashton Cox",
"employee_salary": 86000,
"employee_age": 66,
"profile_image": ""
},
"message": "Successfully! Record has been fetched."
}
     */

    @Test
    public void get01(){
        //1- url ve body hazirla(get methodunda body e gerek yok)
        specDummyBase.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);
        //2- exp data
        TestDataDummy testDataDummy=new TestDataDummy();
        Map<String,Object> expDataMap=testDataDummy.expDataMapOlustur();

        //3-Response u kaydet

        Response response=given().spec(specDummyBase).contentType(ContentType.JSON)
                          .when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        //4-Assertion
        HashMap<String,Object> respMap = response.as(HashMap.class);

        assertEquals(response.getStatusCode(),testDataDummy.basariliStatusCode);

        assertEquals(respMap.get("status"),expDataMap.get("status"));
        assertEquals(respMap.get("message"),expDataMap.get("message"));
        assertEquals (     ((Map)(expDataMap.get("data"))).get("id")    ,
                ((Map)(respMap.get("data"))).get("id")         );

        assertEquals(      ((Map)(expDataMap.get("data"))).get("employee_name")    ,
                ((Map)(respMap.get("data"))).get("employee_name")       );

        assertEquals(      ((Map)(expDataMap.get("data"))).get("employee_salary")    ,
                ((Map)(respMap.get("data"))).get("employee_salary")      );

        assertEquals(       ((Map)(expDataMap.get("data"))).get("employee_age")     ,
                ((Map)(respMap.get("data"))).get("employee_age")       );

        assertEquals(       ((Map)(expDataMap.get("data"))).get("profile_image")     ,
                ((Map)(respMap.get("data"))).get("profile_image")      );


    }
}
