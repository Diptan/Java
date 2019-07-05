package core.driver;

import core.helpers.ConfigFileReader;
import org.openqa.selenium.WebDriver;

public class DriverService {

    private static ThreadLocal<WebDriver> DriverInstance =  ThreadLocal.withInitial(()-> createDriver());

    private static WebDriver createDriver() {
            return DriverFactory.Get(ConfigFileReader.getInstance().getBrowser());
    }

    public static WebDriver getDriver(){
        return DriverInstance.get();
    }
    public static void closeDriver() {
        if (getDriver() != null) {
           getDriver().quit();
        }
        DriverInstance.remove();
    }

}