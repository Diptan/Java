package pageobject.pages;

import core.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageobject.pages.panels.CustomCalendar;

public class HomePage extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = "sb-destination__input")
    public WebElement destinationBox;

    @FindBy(how = How.CLASS_NAME, using = "xp__dates")
    public WebElement checkInDatesButton;

    @FindBy(how = How.CLASS_NAME, using = "sb-searchbox__button")
    public WebElement searchButton ;

    @FindBy(how = How.CLASS_NAME, using = "bui-calendar")
    private WebElement calendarPanel;
    public CustomCalendar calendar = new CustomCalendar(calendarPanel);


}
