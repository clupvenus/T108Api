package test;

import org.json.JSONObject;
import org.junit.Test;

public class C3_JsonObjesiOlusturma {
    /*
    Asagidaki JSON Objesini olusturup
konsolda yazdirin.
{
"title":"Ahmet",
"body":"Merhaba",
"userId":1
}
    */

@Test
    public void jSonObject01(){
    JSONObject ilkJsonObject=new JSONObject();
    ilkJsonObject.put("title","Ahmet");
    ilkJsonObject.put("body","Merhaba");
    ilkJsonObject.put("userId",1);

    System.out.println("ilkJsonObject = " + ilkJsonObject);

    /*
    {
"firstname":"Jim",
"additionalneeds":"Breakfast",
"bookingdates":{
"checkin":"2018-01-01",
"checkout":"2019-01-01"
},
"totalprice":111,
"depositpaid":true,
"lastname":"Brown"
}
     */
    JSONObject bookingDates=new JSONObject();
    bookingDates.put("checkin","2018-01-01");
    bookingDates.put("checkout","2019-01-01");

    JSONObject outerJSONObject=new JSONObject();
    outerJSONObject.put("firstname","Jim");
    outerJSONObject.put("additionalneeds","Breakfast");
    outerJSONObject.put("bookingdates",bookingDates);
    outerJSONObject.put("totalprice",111);
    outerJSONObject.put("depositpaid",true);
    outerJSONObject.put("lastname","Brown");

    System.out.println("outerJSONObject = " + outerJSONObject);

}



}
