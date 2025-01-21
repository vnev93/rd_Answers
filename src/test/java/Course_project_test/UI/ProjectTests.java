package Course_project_test.UI;

import Course_project.TaskUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectTests extends BaseTest {

    @Test
    public void testCreateProject() {
        loginPage.login("admin", "admin");
        driver.get(baseUrl + "/project/create");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.name("name")).sendKeys("Test Project Vlad");
        driver.findElement(By.name("identifier")).sendKeys("New");
        driver.findElement(By.cssSelector(".btn.btn-blue")).click();
        WebElement project = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/header/div[1]/h1/span[2]")));
        Assert.assertTrue(project.isDisplayed());
    }

    @Test
    public void testCreateTask() {
        loginPage.login("admin", "admin");
        driver.get(baseUrl + "/board/12");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement configureProject = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main\"]/div/div[1]/div/a/i[2]")));
        configureProject.click();
        WebElement addNewTask = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dropdown\"]/ul/li[4]/a")));
        addNewTask.click();
        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("title")));
        titleField.sendKeys("Very important task");
        WebElement descriptionField = driver.findElement(By.name("description"));
        descriptionField.sendKeys("Presentation will be for all participants");
        WebElement timeEstimatedField = driver.findElement(By.name("time_estimated"));
        timeEstimatedField.sendKeys("5");
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-blue")));
        submitButton.click();
        WebElement task = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Very important task']")));
        Assert.assertTrue(task.isDisplayed());
    }

    @Test
    public void testManageTask(){
        loginPage.login("admin","admin");
        driver.get(baseUrl + "/task/17");
        WebDriverWait wait = new WebDriverWait(driver,5);
        // Assign to me
        WebElement assignButton = driver.findElement(By.xpath("//a[text()='Assign to me']"));
        assignButton.click();

        // Start task
        WebElement startButton = driver.findElement(By.xpath("//a[text()='Start now']"));
        startButton.click();

        // Close this task
        WebElement closeButton = driver.findElement(By.xpath("//a[text()='Close this task']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",closeButton);
        closeButton.click();

        // Verifying the task is closed
        WebElement confirmationPopUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Yes']")));
        confirmationPopUp.click();
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.title")));
        String titleText = titleElement.getText();
        Assert.assertEquals(titleText, "Test Project Vlad");
    }
    @Test
    public void addCommentToTask(){
        loginPage.login("admin","admin");
        driver.get(baseUrl + "/task/17");
        WebElement addCommentButton = driver.findElement(By.cssSelector("a.js-modal-small"));
        addCommentButton.click();

        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement comment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-content\"]/form/div[1]/div/div[2]/textarea")));
        comment.sendKeys("Whats going on with this project");

        driver.findElement(By.xpath("//*[@id=\"modal-content\"]/form/div[2]/div/button")).click();
        WebElement commentAddedSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("strong.comment-username")));
        Assert.assertTrue(commentAddedSuccess.isDisplayed());
    }
    @Test
    public void deleteCommentFromTask(){
        loginPage.login("admin","admin");
        driver.get(baseUrl + "/task/17");

        WebElement dropDown = driver.findElement(By.xpath("(//a[contains(@class,'dropdown-menu-link-icon')])[5]"));
        dropDown.click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement removeButton = driver.findElement(By.xpath(("//*[@id=\"dropdown\"]/ul/li[4]/a/i")));
        removeButton.click();
        WebDriverWait waiting = new WebDriverWait(driver,5);
        WebElement confirmationPopUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Yes']")));
        confirmationPopUp.click();
        WebElement commentRemovedSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success")));
        Assert.assertTrue(commentRemovedSuccess.isDisplayed());
    }
}

