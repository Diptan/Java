package steps;

import io.qameta.allure.Step;
import pageobject.pages.HomePage;

public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps()
    {
        homePage = new HomePage();
    }

    @Step("Fill search form with data - City: {destination}, Start Date: {startDate}, End Date: {endDate}")
    public void performSearch(String destination, String startDate, String endDate) {
        homePage.destinationBox.click();
        homePage.destinationBox.sendKeys(destination);
        homePage.checkInDatesButton.click();
        homePage.calendar.setDates(startDate, endDate);
        homePage.searchButton.click();
    }

    @Step("Open Booking.com home page")
    public void open()
    {
        homePage.open("");
    }
}
