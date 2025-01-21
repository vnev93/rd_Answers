package Course_project_test.UI;


import Course_project.LoginPage;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class BaseTest {

    protected WebDriver driver;
    protected String baseUrl = "http://localhost";
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Chromedriver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        RestAssured.baseURI = baseUrl;
        loginPage = new LoginPage(driver, baseUrl);
    }

    @AfterClass
    public void terDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
