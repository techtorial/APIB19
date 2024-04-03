package APIAutomationPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.PetStorePojo;
import utils.PayLoad;

public class PetStore {

    @Test
    public void createPet(){
        RestAssured.baseURI="https://petstore.swagger.io/v2";
        RestAssured.basePath="pet";
        Response response=RestAssured.given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .body(PayLoad.getPetPayload("Wolf","King","progress"))
                .when().post()
                .then().log().body()
                .statusCode(200).extract().response();

        PetStorePojo deserializedResponse=response.as(PetStorePojo.class);
        Assert.assertEquals(deserializedResponse.getId(),17);
        Assert.assertEquals(deserializedResponse.getCategory().getId(),98);
        Assert.assertEquals(deserializedResponse.getCategory().getName(),"Wolf");
        Assert.assertEquals(deserializedResponse.getName(),"King");
        Assert.assertEquals(deserializedResponse.getPhotoUrls().getFirst(),"www.dog.com");
        Assert.assertEquals(deserializedResponse.getTags().getFirst().getId(),0);
        Assert.assertEquals(deserializedResponse.getTags().getFirst().getName(),"good");
        Assert.assertEquals(deserializedResponse.getStatus(),"progress");

    }
}
