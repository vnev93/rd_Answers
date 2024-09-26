package Course_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskUtils {
    private WebDriver driver;
    private WebDriverWait wait;

    public TaskUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getLatestTaskUrl() {
        driver.get("http://localhost/tasks");
        WebElement latestTaskLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.task-link")));
        return latestTaskLink.getAttribute("href");
    }
}
