package hollow.phantom.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MessageTest {
    @Test
    public void sendMessage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hollow-phantom.herokuapp.com/");

        WebElement messageFrom = driver.findElement(By.id("messageFrom"));
        messageFrom.sendKeys("Selenium test message");

        WebElement sendMessage = driver.findElement(By.id("sendMessage"));
        sendMessage.click();

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void editMessage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hollow-phantom.herokuapp.com/");

        WebElement editMessage = driver.findElement(By.id("editMessage"));
        editMessage.click();

        WebElement messageFrom = driver.findElement(By.id("messageFrom"));
        messageFrom.sendKeys("Selenium test message edit!");

        WebElement sendMessage = driver.findElement(By.id("sendMessage"));
        sendMessage.click();

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void deleteMessage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hollow-phantom.herokuapp.com/");

        WebElement deleteMessage = driver.findElement(By.id("deleteMessage"));
        deleteMessage.click();

        Thread.sleep(2000);
        driver.quit();
    }
}
