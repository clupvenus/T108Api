package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonHolderBaseUrl {
   // https://jsonplaceholder.typicode.com

 protected RequestSpecification specJSonHolder;

 @Before
    public void setup(){
     specJSonHolder =new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();

 }

}
