package APIAutomationPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.StarWarsCharacterPojo;

import java.util.Arrays;
import java.util.List;

public class StarWars {

    @Test
    public void validateInformation(){

        RestAssured.baseURI="https://swapi.dev";
        RestAssured.basePath="api/people/1";

        Response response=RestAssured.given()
                .header("Accept","application/json")
                .when().get()
                .then().log().body()
                .statusCode(200).extract().response();
        StarWarsCharacterPojo deserializedResponse=response.as(StarWarsCharacterPojo.class);

        Assert.assertEquals(deserializedResponse.getName(),"Luke Skywalker");
        Assert.assertEquals(deserializedResponse.getHeight(),"172");
        Assert.assertEquals(deserializedResponse.getMass(),"77");
        Assert.assertEquals(deserializedResponse.getHair_color(),"blond");
        Assert.assertEquals(deserializedResponse.getSkin_color(),"fair");
        Assert.assertEquals(deserializedResponse.getEye_color(),"blue");
        Assert.assertEquals(deserializedResponse.getBirth_year(),"19BBY");
        Assert.assertEquals(deserializedResponse.getGender(),"male");
        Assert.assertEquals(deserializedResponse.getHomeworld(),"https://swapi.dev/api/planets/1/");
        Assert.assertEquals(deserializedResponse.getFilms().size(),4);
        List<String> expectedFilms= Arrays.asList("https://swapi.dev/api/films/1/","https://swapi.dev/api/films/2/",
        "https://swapi.dev/api/films/3/","https://swapi.dev/api/films/6/");

        for (int i = 0; i <expectedFilms.size() ; i++) {
            Assert.assertEquals(deserializedResponse.getFilms().get(i),expectedFilms.get(i));
        }


    }
}
