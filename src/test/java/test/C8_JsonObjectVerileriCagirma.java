package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C8_JsonObjectVerileriCagirma {
    /*

"firstName":"Ahmet",
"lastName":"Bulut",
"address":{
"streetAddress":"Kurtulus cad.",
"city":"Ankara",
"postalCode":"06100" },
"age":49,
"phoneNumbers":[
{
"number":"532-555 55 55",
"type":"cep" },
{
"number":"0312-123 4567",
"type":"ev " }
]
}
     */
    @Test
    public void jsonPath01(){
        JSONObject cepTel=new JSONObject();
        cepTel.put("number","532-555 55 55");
        cepTel.put("type","cep" );
        JSONObject evTel=new JSONObject();
        evTel.put("number","0312-123 4567");
        evTel.put("type","ev ");
        JSONArray phoneNumbers=new JSONArray();
        phoneNumbers.put(cepTel);
        phoneNumbers.put(evTel);
        JSONObject address=new JSONObject();
        address.put("streetAddress","Kurtulus cad.");
        address.put("city","Ankara");
        address.put( "postalCode","06100");
        JSONObject kisiBilgisi=new JSONObject();
        kisiBilgisi.put("firstName","Ahmet");
        kisiBilgisi.put("lastName","Bulut");
        kisiBilgisi.put("address",address);
        kisiBilgisi.put("age",49);
        kisiBilgisi.put("phoneNumbers",phoneNumbers);
        System.out.println("kisiBilgisi = " + kisiBilgisi);
        
//kisiBilgisi = {"firstName":"Ahmet",
// "lastName":"Bulut",
// "address":{"streetAddress":"Kurtulus cad.",
// "city":"Ankara","postalCode":"06100"}
// ,"phoneNummers":
// [{"number":"532-555 55 55",
// "type":"cep"},
// {"number":"0312-123 4567",
// "type":"ev "}]}

        System.out.println("isim :"+kisiBilgisi.get("firstName"));
        System.out.println("Soyisim :"+kisiBilgisi.get("lastName"));
        System.out.println("Yas :"+kisiBilgisi.get("age"));
        System.out.println("Sokak adi :"+kisiBilgisi.getJSONObject("address").get("streetAddress"));
        System.out.println("Sehir : " + kisiBilgisi.getJSONObject("address").get("city"));
        System.out.println("Cep Tel :" + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        System.out.println("Tel turu :" + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));
        System.out.println("Ev Tel :" + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));
        System.out.println("Tel turu :" + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(1).get("type"));
/*
isim :Ahmet
Soyisim :Bulut
Yas :49
Sokak adi :Kurtulus cad.
Sehir : Ankara
Cep Tel :532-555 55 55
Tel turu :cep
Ev Tel :0312-123 4567
Tel turu :ev
 */

    }


}
