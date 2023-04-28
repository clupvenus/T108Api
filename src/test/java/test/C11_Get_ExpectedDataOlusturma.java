package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.util.Asserts;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C11_Get_ExpectedDataOlusturma {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunu test
ediniz
Response body :
{
"userId": 3,
"id": 22,
"title": "dolor sint quo a velit explicabo quia nam",
"body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}     */
    @Test
    public void get01(){
     //1-URL hazirla
        String url="https://jsonplaceholder.typicode.com/posts/22";
        Response response=given().when().get(url);
        response.prettyPrint();
        //2- Eger soruda bize verilmisse expected data hazirla
        JSONObject expJsonObject=new JSONObject();
        expJsonObject.put("userId", 3);
        expJsonObject.put("id", 22);
        expJsonObject.put("title", "dolor sint quo a velit explicabo quia nam");
        expJsonObject.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        //3- Bize donen Response`i Actual data olarak kaydet.

        JsonPath actualJsonpath=response.jsonPath();
        assertEquals(expJsonObject.get("userId"),actualJsonpath.get("userId"));
        assertEquals(expJsonObject.get("id"),actualJsonpath.get("id"));
        assertEquals(expJsonObject.get("title"),actualJsonpath.get("title"));
        assertEquals(expJsonObject.get("body"),actualJsonpath.get("body"));
    }

}
