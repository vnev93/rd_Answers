package Course_project_test.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void testLogin() {
        // Incorrect username
        loginPage.login("wrongUser","passsword123");
        WebElement error = driver.findElement(By.cssSelector(".alert.alert-error"));
        Assert.assertTrue(error.isDisplayed());

        // Incorrect password
        loginPage.login("admin","wrongPassword");
        error = driver.findElement(By.cssSelector(".alert.alert-error"));
        Assert.assertTrue(error.isDisplayed());
    }

    @Test
    public void testLoginPositiveCase() {
        loginPage.login("admin", "admin");
        WebElement dashboard = driver.findElement(By.className("title"));
        Assert.assertTrue(dashboard.isDisplayed());
    }
}
