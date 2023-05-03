package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataPlaceHolder {
    /*
    Response body :
{
"userId": 3,
"id": 22,
"title": "dolor sint quo a velit explicabo quia nam",
"body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
     */
    public int  basariliStatuskodu=200;
    public String contentType = "application/json; charset=utf-8";
    public String connectionHeaderDegeri = "keep-alive";

    public JSONObject expDataOlustur(){
        JSONObject expData=new JSONObject();
        expData.put("userId", 3);
        expData.put("id", 22);
        expData.put("title", "dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

   return expData;
    }

    public Map<String,Object> reqBodyOlustur(){
      /*  Request Body
        {
            "title": "Ahmet",
                "body": "Merhaba",
                "userId": 10,
                "id": 70*/
        Map<String,Object> reqBody=new HashMap<>();
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId", 10.0);
        reqBody.put("id",70.0);
        return reqBody;
    }
}
