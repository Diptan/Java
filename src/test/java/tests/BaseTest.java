package tests;

import core.driver.DriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void before() {
        DriverService.getDriver();
    }

    @AfterMethod
    public void after() {
        DriverService.closeDriver();
    }
}
