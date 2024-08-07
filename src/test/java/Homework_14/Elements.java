package Homework_14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Elements extends BaseTest{

    @Test
    public void testClickMeButton() {
        driver.get("https://demoqa.com/elements");
        WebElement buttonsMenu = driver.findElement(By.xpath("//span[text()='Buttons']"));
        buttonsMenu.click();
        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickMeButton);

        WebElement message = driver.findElement(By.id("dynamicClickMessage"));
        String messageText = message.getText();
        Assert.assertEquals(messageText, "You have done a dynamic click");
    }
}
