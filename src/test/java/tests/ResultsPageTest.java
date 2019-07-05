package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobject.objects.Location;
import steps.HomePageSteps;
import steps.ResultsPageSteps;

public class ResultsPageTest extends BaseTest
{
    private HomePageSteps homePage;
    private ResultsPageSteps resultPage;

    @BeforeMethod
    public void start(){
        super.before();
        homePage = new HomePageSteps();
        resultPage = new ResultsPageSteps();
    }

    @Test(dataProvider = "Locations")
    public void verifySearchResultsHaveCorrectLocation(String city, double lat, double lon){

        homePage.open();
        homePage.performSearch(city, "2019-04-04", "2019-04-30");
        resultPage.verifyResultsHaveCorrectLocation(0.5, new Location(lat,lon));
    }

    @DataProvider(name = "Locations")
    public static Object[][] locations() {
        return new Object[][] { { "New York", 40.768074,  -73.981895},
                                { "New York", 38.768074,  -73.981895}};
    }

}
