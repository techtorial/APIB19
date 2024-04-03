package utils;

import java.util.Random;

public class PayLoad {

    public static String getPetPayload(String categoryName,String petName,String status){
       String petPayload="{\n" +
               "  \"id\": 17,\n" +
               "  \"category\": {\n" +
               "    \"id\": 98,\n" +
               "    \"name\": \""+categoryName+"\"\n" +
               "  },\n" +
               "  \"name\": \""+petName+"\",\n" +
               "  \"photoUrls\": [\n" +
               "    \"www.dog.com\"\n" +
               "  ],\n" +
               "  \"tags\": [\n" +
               "    {\n" +
               "      \"id\": 0,\n" +
               "      \"name\": \"good\"\n" +
               "    }\n" +
               "  ],\n" +
               "  \"status\": \""+status+"\"\n" +
               "}";
       return petPayload;
    }
}
