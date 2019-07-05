package pageobject.pages.panels;

import core.base.BasePanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CustomCalendar extends BasePanel {
    public CustomCalendar(WebElement element) {
        super(element);
    }

    @FindBy(how = How.CLASS_NAME, using = "bui-calendar__main")
    private WebElement calendarPanel;

    @FindBy(how = How.CLASS_NAME, using = "bui-calendar__control--next")
    private WebElement nextButton;

    public void setDates(String startDate, String endDate) {
        calendarPanel.findElement(By.cssSelector("td[data-date='" + startDate + "']")).click();
        calendarPanel.findElement(By.cssSelector("td[data-date='" + endDate + "']")).click();
    }
}
