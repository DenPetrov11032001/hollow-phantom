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

        chromeDriverUtil.findAndSendElementById(driver, "commentForm", "Selenium test comment");

        chromeDriverUtil.findAndClickElementById(driver, "sendComment");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void sendEmptyComment() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        chromeDriverUtil.findAndSendElementById(driver, "commentForm", "");

        chromeDriverUtil.findAndClickElementById(driver, "sendComment");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void sendSpecialSymbolsComment() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        char uniChar = '\u038A';
        chromeDriverUtil.findAndSendElementById(driver, "commentForm", uniChar + " - alpha");

        chromeDriverUtil.findAndClickElementById(driver, "sendComment");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void sendOverlongComment() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        chromeDriverUtil.findAndSendElementById(driver, "commentForm", "Selenium test comment" +
                " Selenium test comment Selenium test comment " +
                " Selenium test comment Selenium test comment " +
                " Selenium test comment Selenium test comment");

        chromeDriverUtil.findAndClickElementById(driver, "sendComment");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void editCorrectComment() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        chromeDriverUtil.findAndClickElementById(driver, "editComment");

        chromeDriverUtil.findAndSendElementById(driver, "commentForm", "Selenium test comment edit!");

        chromeDriverUtil.findAndClickElementById(driver, "sendComment");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void editEmptyComment() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        chromeDriverUtil.findAndClickElementById(driver, "editComment");

        chromeDriverUtil.findAndSendElementById(driver, "commentForm", "");

        chromeDriverUtil.findAndClickElementById(driver, "sendComment");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void editOverlongComment() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        chromeDriverUtil.findAndClickElementById(driver, "editComment");

        WebElement commentFrom = driver.findElement(By.id("commentFrom"));
        commentFrom.sendKeys("Selenium test comment edit Selenium test comment edit Selenium test comment " +
                "edit! Selenium test comment edit!");

        chromeDriverUtil.findAndSendElementById(driver, "commentForm", "Selenium test comment edit" +
                " Selenium test comment edit " +
                " Selenium test comment edit!" +
                " Selenium test comment edit!");

        chromeDriverUtil.findAndClickElementById(driver, "sendComment");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void deleteComment() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        chromeDriverUtil.findAndClickElementById(driver, "deleteComment");

        chromeDriverUtil.quitFromDriver(driver);
    }
}
