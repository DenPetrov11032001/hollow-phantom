package hollow.phantom.selenium;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProfileTest {
    private ChromeDriverUtil chromeDriverUtil;

    public ProfileTest(ChromeDriverUtil chromeDriverUtil) {
        this.chromeDriverUtil = chromeDriverUtil;
    }

    @Test
    public void changeSubscription() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();
        driver.get("http://hollow-phantom.herokuapp.com/user/113913359212701489857");

        chromeDriverUtil.findAndClickElementById(driver, "changeSubscription");

        chromeDriverUtil.quitFromDriver(driver);
    }

    @Test
    public void approveSubscription() throws InterruptedException {
        ChromeDriver driver = chromeDriverUtil.initializeChromeDriver();
        driver.get("http://hollow-phantom.herokuapp.com/subscriptions/109842214386392189829");

        chromeDriverUtil.findAndClickElementById(driver, "approveSubscription");

        chromeDriverUtil.quitFromDriver(driver);
    }
}
