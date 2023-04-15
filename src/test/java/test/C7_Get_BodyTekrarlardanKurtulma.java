package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C7_Get_BodyTekrarlardanKurtulma {
    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in, "Susan",
ve "lastname“in, "Jackson",
ve "totalprice“in, 612,
ve "depositpaid“in, false,
ve "additionalneeds“in, "Breakfast"
oldugunu test edin

     */
    @Test
    public void get01(){
        //1- Gonderecegimiz request icin gerekli olan URL ve ihtiyacimiz varsa Request Body hazirla.
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2- Eger soruda bize verilmisse expected data hazirla
        //3- Bize donen Response`i Actual data olarak kaydet.
        Response response=given().when().get(url);
        response.prettyPrint();
        //4- Assertion

     /*   response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Susan"),
                         "lastname",Matchers.equalTo ("Jackson"),
                        "totalprice",Matchers.equalTo(612),
                         "depositpaid", Matchers.equalTo(false),
                        "additionalneeds", Matchers.equalTo("Breakfast"));
*/
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Susan"),
                        "lastname",equalTo ("Jackson"),
                        "totalprice",equalTo(612),
                        "depositpaid", equalTo(false),
                        "additionalneeds",equalTo("Breakfast"));
    }
}
