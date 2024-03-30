package APIAutomationPractice;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class GameOfThrones {

    @Test
    public void validateSingleCharacter(){
        RestAssured.baseURI="https://thronesapi.com";
        RestAssured.basePath="/api/v2/Characters/10";

        Response response=RestAssured.given()
                .header("Accept","application/json")
                .when().get()
                .then().log().body()
                .statusCode(200).extract().response();

        Map<String,Object> deserializedResponse= (Map<String, Object>) response.as(new TypeRef<Object>() {});

        Assert.assertEquals(deserializedResponse.get("id"),10);
        Assert.assertEquals(deserializedResponse.get("firstName"),"Cateyln");
        Assert.assertEquals(deserializedResponse.get("lastName"),"Stark");
        Assert.assertEquals(deserializedResponse.get("fullName"),"Catelyn Stark");
        Assert.assertEquals(deserializedResponse.get("title"),"Lady of Winterfell");
        Assert.assertEquals(deserializedResponse.get("family"),"House Stark");
        Assert.assertEquals(deserializedResponse.get("image"),"catelyn-stark.jpg");
        Assert.assertEquals(deserializedResponse.get("imageUrl"),"https://thronesapi.com/assets/images/catelyn-stark.jpg");

    }
}
