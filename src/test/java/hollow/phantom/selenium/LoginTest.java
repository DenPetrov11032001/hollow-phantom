package hollow.phantom.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private ChromeDriverUtil chromeDriverUtil;

    public LoginTest(ChromeDriverUtil chromeDriverUtil) {
        this.chromeDriverUtil = chromeDriverUtil;
    }

    @Test
    public void testCorrectLogin() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement hrefToLogin = driver.findElement(By.id("login"));
        hrefToLogin.click();

        WebElement searchBox = driver.findElement(By.id("identifierId"));
        searchBox.sendKeys("denis11032001");
        searchBox.submit();

        WebElement submitBtn = driver.findElement(By.className("VfPpkd-RLmnJb"));
        submitBtn.click();

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void testNotCorrectLogin() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement hrefToLogin = driver.findElement(By.id("login"));
        hrefToLogin.click();

        WebElement searchBox = driver.findElement(By.id("identifierId"));
        searchBox.sendKeys("");
        searchBox.submit();

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void testLogout() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();

        WebElement logout = driver.findElement(By.id("logout"));
        logout.click();

        chromeDriverUtil.quitFromDriver(driver);
    }
}