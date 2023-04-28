package testData;

import org.json.JSONObject;

public class TestDataHerOku {
    /*{
            "firstname" : "Ahmet",
            "lastname" : “Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                              },
            "additionalneeds" : "wi-fi"
            }*/

   public int basariliStatusKodu = 200;

   //expected data yi bizim icin hazirlayan bir method olusturuyoruz. Method bize Json object verecek.
    //butun class lardan ulasabilmek icin public yapiyoruz.

    public JSONObject reqBodyHerOkuPost(){
        JSONObject reqBody=new JSONObject();
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin" ,"2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");
        reqBody.put(  "firstname" , "Ahmet");
        reqBody.put(  "lastname" ,"Bulut");
        reqBody.put(   "totalprice" ,500);
        reqBody.put(  "depositpaid" ,false);
        reqBody.put(  "bookingdates"  , bookingdates);
        reqBody.put(  "additionalneeds" , "wi-fi");
      return  reqBody;
    }
    public JSONObject expDateHerOkuPost(){
        JSONObject expData=new JSONObject();
         expData.put(  "firstname" , "Ahmet");
         //sadece first name i expected data olarak verdigi icin sadece onu girdim.

        return  expData;
    }


}
