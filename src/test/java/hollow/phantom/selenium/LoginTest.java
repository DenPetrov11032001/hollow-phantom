package hollow.phantom.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    @Test
    public void testLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hollow-phantom.herokuapp.com/");

        WebElement hrefToLogin = driver.findElement(By.id("login"));
        hrefToLogin.click();

        WebElement searchBox = driver.findElement(By.id("identifierId"));
        searchBox.sendKeys("denis11032001");
        searchBox.submit();

        WebElement submitBtn = driver.findElement(By.className("VfPpkd-RLmnJb"));
        submitBtn.click();

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testLogout() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hollow-phantom.herokuapp.com/");

        WebElement logout = driver.findElement(By.id("logout"));
        logout.click();

        Thread.sleep(2000);
        driver.quit();
    }
}