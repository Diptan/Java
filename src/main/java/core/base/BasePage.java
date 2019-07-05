package core.base;

import core.driver.DriverService;
import core.helpers.ConfigFileReader;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(DriverService.getDriver(), this);
    }

    public void open(String relativeUrl){
        DriverService.getDriver().navigate().to(ConfigFileReader.getInstance().getApplicationUrl() + relativeUrl);
    }
}
