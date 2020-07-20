package hollow.phantom.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommentTest {
    @Test
    public void sendComment() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hollow-phantom.herokuapp.com/");

        WebElement commentFrom = driver.findElement(By.id("commentFrom"));
        commentFrom.sendKeys("Selenium test comment");

        WebElement sendComment = driver.findElement(By.id("sendComment"));
        sendComment.click();

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void editComment() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hollow-phantom.herokuapp.com/");

        WebElement editComment = driver.findElement(By.id("editComment"));
        editComment.click();

        WebElement commentFrom = driver.findElement(By.id("commentFrom"));
        commentFrom.sendKeys("Selenium test comment edit!");

        WebElement sendComment = driver.findElement(By.id("sendComment"));
        sendComment.click();

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void deleteComment() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hollow-phantom.herokuapp.com/");

        WebElement deleteComment = driver.findElement(By.id("deleteComment"));
        deleteComment.click();

        Thread.sleep(2000);
        driver.quit();
    }
}
