package Books;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class HTTPMethods {

    @Test
    public void authorization(){
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        RestAssured.basePath="auth";

        Response response=RestAssured.given()
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}")
                .when().post()
                .then().log().body().extract().response();

        Map<String,Object> deserializedResponse=response.as(new TypeRef<Map<String, Object>>() {});
        System.out.println(deserializedResponse.get("token"));
        Assert.assertNotNull(deserializedResponse.get("token"));
    }

    @Test
    public void getSingleBookId(){
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        RestAssured.basePath="booking/2542";

        Response response=RestAssured.given()
                .header("Accept","application/json")
                .queryParam("firstname","Ahmet123")
                .queryParam("lastname","Baldir")
                .when().get()
                .then().log().body()
                .statusCode(200).extract().response();

        List<Map<String,Object>> deserializedBookId=response.as(new TypeRef<List<Map<String, Object>>>() {});
        Assert.assertNotNull(deserializedBookId.get(0).get("bookingid"));
    }

    @Test
    public void getBookDetails(){

        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        RestAssured.basePath="booking/{id}";

        Response response=RestAssured.given()
                .pathParams("id","1309")
                .header("Accept","application/json")
                .when().get()
                .then().log().body()
                .statusCode(200).extract().response();

        Map<String,Object> deserializedResponse=response.as(new TypeRef<Map<String, Object>>() {});

        Assert.assertEquals(deserializedResponse.get("firstname"),"Ahmet");
        Assert.assertEquals(deserializedResponse.get("lastname"),"Baldir");
        Assert.assertEquals(deserializedResponse.get("totalprice"),999);
        Assert.assertEquals(deserializedResponse.get("depositpaid"),true);
        Assert.assertEquals(deserializedResponse.get("additionalneeds"),"SDET IT");
        Map<String,String> bookingDatesInformation= (Map<String, String>) deserializedResponse.get("bookingdates");
        Assert.assertEquals(bookingDatesInformation.get("checkin"),"2024-01-01");
        Assert.assertEquals(bookingDatesInformation.get("checkout"),"2024-01-05");
    }

    @Test
    public void updateBook(){

        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        RestAssured.basePath="booking/{id}";

        Response response=RestAssured.given()
                .pathParams("id","311")
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .body("{\n" +
                        "    \"firstname\" : \"Ahmet\",\n" +
                        "    \"lastname\" : \"BalTest\",\n" +
                        "    \"totalprice\" : 999,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when().put()
                .then().log().body()
                .statusCode(200).extract().response();

        Map<String,Object> deserializedResponse=response.as(new TypeRef<Map<String, Object>>() {});

        Assert.assertEquals(deserializedResponse.get("firstname"),"Ahmet");
        Map<String,String> bookingInfo= (Map<String, String>) deserializedResponse.get("bookingdates");
        Assert.assertEquals(bookingInfo.get("checkin"),"2018-01-01");
    }

}
