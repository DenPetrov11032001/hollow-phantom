package hollow.phantom.selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverUtil {
    protected ChromeDriver initializeChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/denis/chromedriver/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://hollow-phantom.herokuapp.com/");
        return driver;
    }

    protected void quitFromDriver(ChromeDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
