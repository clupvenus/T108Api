package testData;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataDummy {
    public int basariliStatusCode = 200;
    /*
    Request Body
{
"status": "success",
"data": {
     "name": "Leyla",
     "salary": "1230",
      "age": "44",
      "id": 41
}
}
     */
    public JSONObject reqBody(){
        JSONObject data=new JSONObject();
        data.put( "name", "Leyla");
        data.put("salary", "1230");
        data.put("age", "44");
        data.put("id", 41);

        JSONObject allData=new JSONObject();
        allData.put("data", data);
        allData.put("status", "success");

        return  allData;
    }

    public JSONObject expBody(){
        /*
    {
    "status": "success",
        "data": {
            "name": "Leyla",
            "id": 41,
            "salary": "1230",
            "age": "44"
        },
        "status": "success",
        "id": 1198
    },
    "message": "Successfully! Record has been updated."
}
         */
        JSONObject data=new JSONObject();
        data.put( "name", "Leyla");
        data.put("salary", "1230");
        data.put("age", "44");
        data.put("id", 41);

        JSONObject expData=new JSONObject();

        expData.put("status", "success");
        expData.put("status", "success");
        expData.put("data", data);
        expData.put("message","Successfully! Record has been updated.");
        return  expData;
    }
    public Map<String,Object> expDataMapOlustur(){

    /*
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
        Map<String,Object> DataMap=new HashMap<>();
        DataMap.put("id", 3.0);
        DataMap.put("employee_name","Ashton Cox");
        DataMap.put("employee_salary",86000.0);
        DataMap.put("profile_image", "");
        Map<String,Object> expData=new HashMap<>();
        expData.put("status","success");
        expData.put( "data",DataMap);
        expData.put("message","Successfully! Record has been fetched.");


return expData;
}


}