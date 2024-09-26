package Course_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private String baseUrl;

    public LoginPage(WebDriver driver, String baseUrl){
        this.driver = driver;
        this.baseUrl = baseUrl;
    }
    public void login(String username, String password){
        driver.get(baseUrl + "/login");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector(".btn.btn-blue")).click();
    }
}

