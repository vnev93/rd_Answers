package Homework_14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTables extends BaseTest{

    @Test
    public void testAddAndEditEntry(){
        driver.get("https://demoqa.com/webtables");

        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();

        driver.findElement(By.id("firstName")).sendKeys("Peter");
        driver.findElement(By.id("lastName")).sendKeys("Parker");
        driver.findElement(By.id("userEmail")).sendKeys("peter.parker@gmail.com");
        driver.findElement(By.id("age")).sendKeys("17");
        driver.findElement(By.id("salary")).sendKeys("1000");
        driver.findElement(By.id("department")).sendKeys("MarvelSuperStar");
        driver.findElement(By.id("submit")).click();


        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        WebElement newForm = driver.findElement(By.xpath("//div[text()= \"MarvelSuperStar\"]"));
        Assert.assertTrue((newForm.getText().contains("MarvelSuperStar")));

        WebElement editButton = driver.findElement(By.xpath(("//span[@id='edit-record-4']")));
        editButton.click();
        WebElement firstNameEdit = driver.findElement(By.id("firstName"));
        firstNameEdit.clear();
        firstNameEdit.sendKeys("Miles");
        driver.findElement(By.id("submit")).click();

    }
}
