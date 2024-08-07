package Homework_14;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Chromedriver\\chromedriver-win64\\chromedriver.exe");
    }

    @BeforeMethod
    public void setUP() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethodAction(ITestResult result) {
        if (!result.isSuccess()) {
            Allure.addAttachment(result.getMethod().getMethodName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
        driver.quit();
    }
}