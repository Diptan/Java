package core.base;

import core.driver.DriverService;
import core.driver.WebDriverWrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePanel{

    protected BasePanel(WebElement element){
        WebDriverWrapper webDriverWrapper = new WebDriverWrapper(DriverService.getDriver(), element);
        PageFactory.initElements(webDriverWrapper, this);
    }
}

