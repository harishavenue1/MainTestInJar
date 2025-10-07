package org.example;

import io.restassured.response.Response;
import org.example.api.JsonPlaceholderAPI;
import org.testng.annotations.*;

import static org.hamcrest.Matchers.*;

public class JsonPlaceholderAPITest {
    private JsonPlaceholderAPI api;
    
    @BeforeMethod
    public void setUp() {
        api = new JsonPlaceholderAPI();
    }
    
    @Test(groups = "api")
    public void testGetAllPosts() {
        Response response = api.getAllPosts();
        response.then()
                .log().all()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }
    
    @Test(groups = "api")
    public void testGetSinglePost() {
        Response response = api.getPost(1);
        response.then()
                .log().all()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("title", notNullValue());
    }
    
    @Test(groups = "api")
    public void testCreatePost() {
        Response response = api.createPost("Test Post", "Test Body", 1);
        response.then()
                .log().all()
            .statusCode(201)
            .body("title", equalTo("Test Post"));
    }
}