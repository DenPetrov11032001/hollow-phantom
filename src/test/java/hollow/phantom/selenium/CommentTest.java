package hollow.phantom.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommentTest {
    private ChromeDriverUtil chromeDriverUtil;

    public CommentTest(ChromeDriverUtil chromeDriverUtil) {
        this.chromeDriverUtil = chromeDriverUtil;
    }

    @Test
    public void sendCorrectComment() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement commentFrom = driver.findElement(By.id("commentFrom"));
        commentFrom.sendKeys("Selenium test comment");

        WebElement sendComment = driver.findElement(By.id("sendComment"));
        sendComment.click();

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void sendEmptyComment() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement commentFrom = driver.findElement(By.id("commentFrom"));
        commentFrom.sendKeys("");

        WebElement sendComment = driver.findElement(By.id("sendComment"));
        sendComment.click();

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void sendOverlongComment() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement commentFrom = driver.findElement(By.id("commentFrom"));
        commentFrom.sendKeys("Selenium test comment Selenium test comment Selenium test comment " +
                "Selenium test comment Selenium test comment Selenium test comment Selenium test comment");

        WebElement sendComment = driver.findElement(By.id("sendComment"));
        sendComment.click();

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void editCorrectComment() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement editComment = driver.findElement(By.id("editComment"));
        editComment.click();

        WebElement commentFrom = driver.findElement(By.id("commentFrom"));
        commentFrom.sendKeys("Selenium test comment edit!");

        WebElement sendComment = driver.findElement(By.id("sendComment"));
        sendComment.click();

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void editEmptyComment() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement editComment = driver.findElement(By.id("editComment"));
        editComment.click();

        WebElement commentFrom = driver.findElement(By.id("commentFrom"));
        commentFrom.sendKeys("");

        WebElement sendComment = driver.findElement(By.id("sendComment"));
        sendComment.click();

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void editOverlongComment() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement editComment = driver.findElement(By.id("editComment"));
        editComment.click();

        WebElement commentFrom = driver.findElement(By.id("commentFrom"));
        commentFrom.sendKeys("Selenium test comment edit Selenium test comment edit Selenium test comment " +
                "edit! Selenium test comment edit!");

        WebElement sendComment = driver.findElement(By.id("sendComment"));
        sendComment.click();

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void deleteComment() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement deleteComment = driver.findElement(By.id("deleteComment"));
        deleteComment.click();

        chromeDriverUtil.quitFromDriver(driver);
    }
}
