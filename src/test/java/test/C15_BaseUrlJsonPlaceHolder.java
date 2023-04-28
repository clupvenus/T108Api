package test;

import baseURL.JsonHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

public class C15_BaseUrlJsonPlaceHolder extends JsonHolderBaseUrl {
    /*
    Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve
Response’ta 100 kayit oldugunu test edin
2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve “title”
degerinin “optio dolor molestias sit” oldugunu test edin
3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve response
body’sinin null oldugunu test edin

     */
    @Test
    public void get01(){
        /*
        1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve
Response’ta 100 kayit oldugunu test edin
         */
       //1- url hazirla
        specJSonHolder.pathParam("pp1","posts");
        //2- expected data
        //3- response i kaydet

        Response response=given().spec(specJSonHolder).when().get("/{pp1}");
        //response.prettyPrint();
        //4-Assertion
        response.then().assertThat().statusCode(200).body("id", hasSize(100));

    }
    @Test
    public void get02(){
/*
2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve “title”
degerinin “optio dolor molestias sit” oldugunu test edin
 */
        //1- url hazirla
        specJSonHolder.pathParams("pp1","posts","pp2",44);
        //2- Expected data
        //3-response i kaydet
        Response response=given().spec(specJSonHolder).when().get("/{pp1}/{pp2}");
        response.prettyPrint();
        //4- Assertion
         response.then()
                 .assertThat()
                 .statusCode(200)
                 .body("title",equalTo("optio dolor molestias sit"));
    }
    @Test
    public void delete01(){
      /*  3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve response
        body’sinin null oldugunu test edin
     */
     //1-url hazirla
     specJSonHolder.pathParams("pp1","posts","pp2",50);
     //2-expected data hazirla
     //3-response i kaydet
        Response response=given().spec(specJSonHolder).when().delete("/{pp1}/{pp2}");

     //4- Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .body("body",Matchers.nullValue());


    }

}
