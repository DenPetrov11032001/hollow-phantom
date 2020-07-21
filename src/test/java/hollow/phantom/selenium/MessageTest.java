package hollow.phantom.selenium;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class MessageTest {
    private ChromeDriverUtil chromeDriverUtil;

    public MessageTest(ChromeDriverUtil chromeDriverUtil) {
        this.chromeDriverUtil = chromeDriverUtil;
    }

    @Test
    public void sendCorrectMessage() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        chromeDriverUtil.findAndSendElementById(driver, "messageForm", "Selenium test message");

        chromeDriverUtil.findAndClickElementById(driver, "sendMessage");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void sendEmptyMessage() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        chromeDriverUtil.findAndSendElementById(driver, "messageForm", "");

        chromeDriverUtil.findAndClickElementById(driver, "sendMessage");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void sendSpecialSymbolsMessage() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        chromeDriverUtil.findAndSendElementById(driver, "messageForm", '\u039A' + " - K" + "\\[" + "\\\\");

        chromeDriverUtil.findAndClickElementById(driver, "sendMessage");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void sendOverlongMessage() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        chromeDriverUtil.findAndSendElementById(driver, "messageForm", "Selenium test very long message" +
                " Selenium test very long message Selenium test very long message" +
                " Selenium test very long message Selenium test very long message Selenium " +
                "test very long message Selenium test very long message Selenium test very" +
                " long message Selenium test very long message Selenium test very long message");

        chromeDriverUtil.findAndClickElementById(driver, "sendMessage");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void editMessageCorrect() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        chromeDriverUtil.findAndClickElementById(driver, "editMessage");

        chromeDriverUtil.findAndSendElementById(driver, "messageForm", "Selenium test message edit!");

        chromeDriverUtil.findAndClickElementById(driver, "sendMessage");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void editMessageEmpty() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        chromeDriverUtil.findAndClickElementById(driver, "editMessage");

        chromeDriverUtil.findAndSendElementById(driver, "messageForm", "");

        chromeDriverUtil.findAndClickElementById(driver, "sendMessage");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void editOverlongMessage() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        chromeDriverUtil.findAndClickElementById(driver, "editMessage");

        chromeDriverUtil.findAndSendElementById(driver, "messageForm", "Selenium test very long message" +
                " Selenium test very long message Selenium test very long message" +
                " Selenium test very long message Selenium test very long message Selenium " +
                "test very long message Selenium test very long message Selenium test very" +
                " long message Selenium test very long message Selenium test very long message");

        chromeDriverUtil.findAndClickElementById(driver, "sendMessage");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void deleteMessage() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        chromeDriverUtil.findAndClickElementById(driver, "deleteMessage");

        chromeDriverUtil.quitFromDriver(driver);
    }
}
