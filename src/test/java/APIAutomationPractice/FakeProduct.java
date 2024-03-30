package APIAutomationPractice;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class FakeProduct {

    @Test
    public void validateSingleProductInformation(){
        /*
        1-Defined the url(endpoint)-->https://fakestoreapi.com/products/1
        2-Check the HTTP method    -->GET,POST,DELETE,PUT,PATCH
        3-Check the header         -->Content-Type, Accept, Authorization etc...
        4-Check the parameters     -->Path Parameter,Query String parameter...etc
        5-Send the request and validate the status code
         */

        Response response=RestAssured.given()//given is referring what is precondition for the end point
                .header("Accept","application/json")
                .when() //what http methods do you send
                .get("https://fakestoreapi.com/products/1")
                .then()
                .log().body()
                .statusCode(200).extract().response();

        Map<String,Object> deserializedResponse= (Map<String, Object>) response.as(new TypeRef<Object>() {});
        System.out.println(deserializedResponse);
        Assert.assertEquals(deserializedResponse.get("id"),1);
        Assert.assertEquals(deserializedResponse.get("title"),"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops");
        Assert.assertEquals(deserializedResponse.get("price"),109.95);
        Assert.assertEquals(deserializedResponse.get("description"),"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday");
        Assert.assertEquals(deserializedResponse.get("category"),"men's clothing");
        Assert.assertEquals(deserializedResponse.get("image"),"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg");
    }

    @Test
    public void validateSingleProductInformation2(){

        RestAssured.baseURI="https://fakestoreapi.com";//base url
        RestAssured.basePath="products/1";//end point

        Response response=RestAssured.given()//given is referring what is precondition for the end point
                .header("Accept","application/json")
                .when() //what http methods do you send
                .get()
                .then()
                .log().body()
                .statusCode(200).extract().response();

        Map<String,Object> deserializedResponse= response.as(new TypeRef<>() {});
        System.out.println(deserializedResponse);
        Assert.assertEquals(deserializedResponse.get("id"),1);
        Assert.assertEquals(deserializedResponse.get("title"),"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops");
        Assert.assertEquals(deserializedResponse.get("price"),109.95);
        Assert.assertEquals(deserializedResponse.get("description"),"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday");
        Assert.assertEquals(deserializedResponse.get("category"),"men's clothing");
        Assert.assertEquals(deserializedResponse.get("image"),"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg");
        Map<String,Object> ratingInformation= (Map<String, Object>) deserializedResponse.get("rating");
        Assert.assertEquals(ratingInformation.get("rate"),3.9);
        Assert.assertEquals(ratingInformation.get("count"),120);

    }
}
