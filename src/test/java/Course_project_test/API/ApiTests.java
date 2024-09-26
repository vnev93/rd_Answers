
package Course_project_test.API;

import Course_project_test.UI.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApiTests extends BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseUrl;
    }

    @Test
    public void testCreateUser() {
        String requestBody = "{ \"username\": \"testuser\", \"password\": \"password123\", \"email\": \"testuser@example.com\" }";

        Response response = RestAssured
                .given()
                .auth().preemptive().basic("admin", "admin")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/api/users");

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertTrue(response.jsonPath().getString("username").equals("testuser"));
    }

    @Test(dependsOnMethods = "testCreateUser")
    public void testDeleteUser() {
        Response response = RestAssured
                .given()
                .auth().preemptive().basic("admin", "admin")
                .delete("/api/users/testuser");

        Assert.assertEquals(response.getStatusCode(), 204);
    }

    @Test
    public void testCreateTask() {
        String requestBody = "{ \"title\": \"Very important task\", \"description\": \"Presentation will be for all participants\", \"time_estimated\": \"5\" }";

        Response response = RestAssured
                .given()
                .auth().preemptive().basic("admin", "admin")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/api/projects/12/tasks");

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertTrue(response.jsonPath().getString("title").equals("Very important task"));
    }

    @Test(dependsOnMethods = "testCreateTask")
    public void testDeleteTask() {
        Response response = RestAssured
                .given()
                .auth().preemptive().basic("admin", "admin")
                .delete("/api/projects/12/tasks/1");

        Assert.assertEquals(response.getStatusCode(), 204);
    }

    @Test
    public void testCreateProject() {
        String requestBody = "{ \"name\": \"Test Project Vlad\", \"identifier\": \"New\" }";

        Response response = RestAssured
                .given()
                .auth().preemptive().basic("admin", "admin")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/api/projects");

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertTrue(response.jsonPath().getString("name").equals("Test Project Vlad"));
    }

    @Test(dependsOnMethods = "testCreateProject")
    public void testDeleteProject() {
        Response response = RestAssured
                .given()
                .auth().preemptive().basic("admin", "admin")
                .delete("/api/projects/New");

        Assert.assertEquals(response.getStatusCode(), 204);
    }
}
