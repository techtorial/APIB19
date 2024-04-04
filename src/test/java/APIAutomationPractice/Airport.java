package APIAutomationPractice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Airport {

    @Test
    public void validateAirportInformation(){
        RestAssured.baseURI="https://airportgap.dev-tester.com";
        RestAssured.basePath="api/airports";

        Response response=RestAssured.given().header("Accept","application/json")
                .when().get()
                .then().log().body()
                .statusCode(200).extract().response();

        JsonPath deserializedResponse=response.jsonPath();

        Assert.assertEquals(deserializedResponse.getString("data[0].id"),"GKA");
        Assert.assertEquals(deserializedResponse.getString("data[0].type"),"airport");
        Assert.assertEquals(deserializedResponse.getString("data[0].attributes.name"),"Goroka Airport");
        Assert.assertEquals(deserializedResponse.getString("data[0].attributes.city"),"Goroka");
        Assert.assertEquals(deserializedResponse.getString("data[0].attributes.country"),"Papua New Guinea");

    }
    @Test
    public void validateAirportInformationWithMatchers(){
        RestAssured.baseURI="https://airportgap.dev-tester.com";
        RestAssured.basePath="api/airports";

        Response response=RestAssured.given().header("Accept","application/json")
                .when().get()
                .then().log().body()
                .body("data[0].id",Matchers.equalTo("GKA"))

                .statusCode(200).extract().response();

        JsonPath deserializedResponse=response.jsonPath();

        Assert.assertEquals(deserializedResponse.getString("data[0].id"),"GKA");
        Assert.assertEquals(deserializedResponse.getString("data[0].type"),"airport");
        Assert.assertEquals(deserializedResponse.getString("data[0].attributes.name"),"Goroka Airport");
        Assert.assertEquals(deserializedResponse.getString("data[0].attributes.city"),"Goroka");
        Assert.assertEquals(deserializedResponse.getString("data[0].attributes.country"),"Papua New Guinea");



    }
}
