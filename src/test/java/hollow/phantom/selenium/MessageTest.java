package hollow.phantom.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MessageTest {
    private ChromeDriverUtil chromeDriverUtil;

    public MessageTest(ChromeDriverUtil chromeDriverUtil) {
        this.chromeDriverUtil = chromeDriverUtil;
    }

    @Test
    public void sendCorrectMessage() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement messageFrom = driver.findElement(By.id("messageFrom"));
        messageFrom.sendKeys("Selenium test message");

        WebElement sendMessage = driver.findElement(By.id("sendMessage"));
        sendMessage.click();

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void sendEmptyMessage() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement messageFrom = driver.findElement(By.id("messageFrom"));
        messageFrom.sendKeys("");

        WebElement sendMessage = driver.findElement(By.id("sendMessage"));
        sendMessage.click();

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void sendOverlongMessage() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement messageFrom = driver.findElement(By.id("messageFrom"));
        messageFrom.sendKeys("Selenium test very long message" +
                " Selenium test very long message Selenium test very long message" +
                " Selenium test very long message Selenium test very long message Selenium " +
                "test very long message Selenium test very long message Selenium test very" +
                " long message Selenium test very long message Selenium test very long message");

        WebElement sendMessage = driver.findElement(By.id("sendMessage"));
        sendMessage.click();

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void editMessageCorrect() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement editMessage = driver.findElement(By.id("editMessage"));
        editMessage.click();

        WebElement messageFrom = driver.findElement(By.id("messageFrom"));
        messageFrom.sendKeys("Selenium test message edit!");

        WebElement sendMessage = driver.findElement(By.id("sendMessage"));
        sendMessage.click();

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void editMessageEmpty() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement editMessage = driver.findElement(By.id("editMessage"));
        editMessage.click();

        WebElement messageFrom = driver.findElement(By.id("messageFrom"));
        messageFrom.sendKeys("");

        WebElement sendMessage = driver.findElement(By.id("sendMessage"));
        sendMessage.click();

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void editOverlongMessage() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement editMessage = driver.findElement(By.id("editMessage"));
        editMessage.click();

        WebElement messageFrom = driver.findElement(By.id("messageFrom"));
        messageFrom.sendKeys("Selenium test very long message" +
                " Selenium test very long message Selenium test very long message" +
                " Selenium test very long message Selenium test very long message Selenium " +
                "test very long message Selenium test very long message Selenium test very" +
                " long message Selenium test very long message Selenium test very long message");

        WebElement sendMessage = driver.findElement(By.id("sendMessage"));
        sendMessage.click();

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void deleteMessage() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement deleteMessage = driver.findElement(By.id("deleteMessage"));
        deleteMessage.click();

        chromeDriverUtil.quitFromDriver(driver);
    }
}
