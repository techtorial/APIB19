package APIAutomationPractice;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class CatFacts {

    @Test
    public void CountingTheFacts() {

        RestAssured.baseURI = "https://catfact.ninja";
        RestAssured.basePath = "facts";

        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .queryParam("limit", "332")
                .when().get()
                .then().log().body()
                .statusCode(200).extract().response();

        Map<String, Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {});
        Assert.assertEquals(deserializedResponse.get("total"), 332);

        List<Map<String,Object>> allData= (List<Map<String, Object>>) deserializedResponse.get("data");
        System.out.println(allData.size());
        int moreThan50=0;
        int lessThan200=0;
        int mix=0;
        int catNumber=0;

        for(Map<String,Object> data:allData){
            if((int)data.get("length")>50){
                moreThan50++;
            }
            if((int)data.get("length")<200){
                lessThan200++;
            }
            if((int)data.get("length")>50 && (int)data.get("length")<200){
                mix++;
            }
            if(data.get("fact").toString().contains("cat")){
                catNumber++;
            }
        }
        System.out.println(moreThan50);
        System.out.println(lessThan200);
        System.out.println(mix);
        System.out.println(catNumber);
       /*
       1-Validate the total is 332
       2-Count how many of the facts length is more than 50
       3-Count How many of the facts length is less than 200
       4-Count how many of the facts length is more than 50 less than 200
       5-Count how many of the facts contains "cat" keyword
        */
    }
}
