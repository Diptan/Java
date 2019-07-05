package core.driver;

import core.helpers.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver Get(String driverName) {
        String lower = driverName.toLowerCase();
        if ("chrome".equals(lower)) {
            return ConfigureDriver(GetChromeDriver());
        } else if ("firefox".equals(lower)) {
            return ConfigureDriver(GetFirefoxDriver());
        } else if ("localchrome".equals(lower)) {
            return ConfigureDriver(GetLocalChromeDriver());
        }
        throw new UnsupportedOperationException("Can not find driver " + driverName);
    }

    private static WebDriver ConfigureDriver(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(ConfigFileReader.getInstance().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    private static FirefoxDriver GetFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver webDriver = new FirefoxDriver();

        return webDriver;
    }

    private static RemoteWebDriver GetChromeDriver() {
        throw new UnsupportedOperationException();
    }

    private static ChromeDriver GetLocalChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();

        return webDriver;
    }
}
