package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RestfulBookerBaseUrl {
    //https://restful-booker.herokuapp.com

    protected RequestSpecification specHerokuApp;

    @Before
    public void setUpRestful(){
        specHerokuApp=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();


    }
}
