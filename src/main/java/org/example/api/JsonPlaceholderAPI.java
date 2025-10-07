package org.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class JsonPlaceholderAPI {
    
    public JsonPlaceholderAPI() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    
    public Response getAllPosts() {
        return given().when().get("/posts");
    }
    
    public Response getPost(int id) {
        return given().when().get("/posts/" + id);
    }
    
    public Response createPost(String title, String body, int userId) {
        String requestBody = String.format(
            "{\"title\":\"%s\",\"body\":\"%s\",\"userId\":%d}",
            title, body, userId
        );
        
        return given()
            .header("Content-Type", "application/json")
            .body(requestBody)
            .when()
            .post("/posts");
    }
}