package test;

import baseURL.DummyBaseUrl;
        import io.restassured.response.Response;
        import org.junit.Assert;
        import org.junit.Test;
        import PojoS.PojoDummyData;
        import PojoS.PojoDummyExpBody;

        import static io.restassured.RestAssured.given;
        import static org.junit.Assert.assertEquals;

public class C27_Get_Pojo_Veda_Classi extends DummyBaseUrl {

     /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
     gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

	Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }

     */

    @Test
    public void get01() {

        // 1 - Url hazirla

        specDummyBase.pathParams("pp1", "api", "pp2", "v1", "pp3", "employee", "pp4", 3);

        // 2 - Expected Data

        PojoDummyData data = new PojoDummyData(3, "Ashton Cox", 86000, 66, "");

        PojoDummyExpBody expBody = new PojoDummyExpBody("success", data, "Successfully! Record has been fetched.");

        // 3 - Response'i kaydet

        Response response = given().spec(specDummyBase).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        response.prettyPrint();

        // 4 - Assertion

        PojoDummyExpBody resPojo = response.as(PojoDummyExpBody.class);

        assertEquals(expBody.getStatus(), resPojo.getStatus());
        assertEquals(expBody.getMessage(), resPojo.getMessage());
        assertEquals(expBody.getData().getId(), resPojo.getData().getId());
        assertEquals(expBody.getData().getEmployee_name(), resPojo.getData().getEmployee_name());
        assertEquals(expBody.getData().getEmployee_salary(), resPojo.getData().getEmployee_salary());
        assertEquals(expBody.getData().getEmployee_age(), resPojo.getData().getEmployee_age());
        assertEquals(expBody.getData().getProfile_image(), resPojo.getData().getProfile_image());

    }
}